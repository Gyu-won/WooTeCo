package oncall.domain.repository;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.TimeTable;
import oncall.view.message.Error;

public class WorkerRepository {
    private static final Deque<String> weekdayWorkers = new LinkedList<>();
    private static final Deque<String> holidayWorkers = new LinkedList<>();

    public static void registerWeekdayWorker(List<String> workers) {
        for (int i = 0; i < 7; i++) {
            workers.forEach(weekdayWorkers::push);
        }
    }

    public static void checkIsSameWithWeekdayWorker(List<String> workerNames) {
        workerNames.forEach(WorkerRepository::checkIsContainInWeekDayWorker);
        checkSameSize(workerNames);
    }

    private static void checkSameSize(List<String> workerNames) {
        if (workerNames.size() != weekdayWorkers.size() / 7) {
            throw new IllegalArgumentException(Error.INVALID_WORKER.getMessage());
        }
    }

    public static void checkIsContainInWeekDayWorker(String holidayWorker) {
        if (!weekdayWorkers.contains(holidayWorker)) {
            throw new IllegalArgumentException(Error.INVALID_WORKER.getMessage());
        }
    }

    public static void registerHolidayWorker(List<String> workers) {
        for (int i = 0; i < 7; i++) {
            workers.forEach(holidayWorkers::addLast);
        }
    }

    public static void createTimeTable() {
        TimeTable.add("");
        int lastDay = Calender.lastDay();
        for (int day = 1; day <= lastDay; day++) {
            addToTimeTable(day, findFirstWorker(day));
        }
    }

    private static void addToTimeTable(Integer day, String worker) {
        while (TimeTable.isWorkBefore(worker)) {
            addToTimeTable(day, findNextWorker(day, worker));
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
