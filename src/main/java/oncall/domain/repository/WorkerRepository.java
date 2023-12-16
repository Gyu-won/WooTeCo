package oncall.domain.repository;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.TimeTable;
import oncall.view.message.Error;

public class WorkerRepository {
    private static final int FIRST_DAY = 1;
    private static final int DAY_OF_WEEK = 7;
    private static final String INITIAL_VALUE = "";

    private static final Deque<String> weekdayWorkers = new LinkedList<>();
    private static final Deque<String> holidayWorkers = new LinkedList<>();

    public static void checkIsSame(List<String> weekdayWorkerNames, List<String> holidayWorkerNames) {
        weekdayWorkerNames.forEach(
                weekdayWorkerName -> checkIsContainHolidayWorker(weekdayWorkerName, holidayWorkerNames));
        checkSameSize(weekdayWorkerNames, holidayWorkerNames);
    }

    private static void checkIsContainHolidayWorker(String weekdayWorkerName, List<String> holidayWorkerNames) {
        if (!holidayWorkerNames.contains(weekdayWorkerName)) {
            throw new IllegalArgumentException(Error.INVALID_WORKER.getMessage());
        }
    }

    private static void checkSameSize(List<String> weekdayWorkerNames, List<String> holidayWorkerNames) {
        if (weekdayWorkerNames.size() != holidayWorkerNames.size()) {
            throw new IllegalArgumentException(Error.INVALID_WORKER.getMessage());
        }
    }

    public static void registerWorker(List<String> weekdayWorker, List<String> holidayWorker) {
        for (int i = FIRST_DAY; i <= DAY_OF_WEEK; i++) {
            weekdayWorker.forEach(weekdayWorkers::addLast);
            holidayWorker.forEach(holidayWorkers::addLast);
        }
    }

    public static void createTimeTable() {
        TimeTable.add(INITIAL_VALUE);
        int lastDay = Calender.lastDay();
        for (int day = FIRST_DAY; day <= lastDay; day++) {
            addToTimeTable(day, findFirstWorker(day));
        }
    }

    private static void addToTimeTable(Integer day, String worker) {
        while (TimeTable.isWorkBefore(worker)) {
            worker = findNextWorker(day, worker);
        }
        TimeTable.add(worker);
    }

    private static String findNextWorker(Integer day, String worker) {
        if (Calender.isHoliday(day)) {
            String nextWorker = holidayWorkers.pop();
            holidayWorkers.addFirst(worker);
            return nextWorker;
        }
        String nextWorker = weekdayWorkers.pop();
        weekdayWorkers.addFirst(worker);
        return nextWorker;
    }

    private static String findFirstWorker(int day) {
        if (Calender.isHoliday(day)) {
            return holidayWorkers.pop();
        }
        return weekdayWorkers.pop();
    }
}
