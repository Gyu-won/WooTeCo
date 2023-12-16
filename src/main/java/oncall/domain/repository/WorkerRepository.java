package oncall.domain.repository;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import oncall.view.message.Error;

public class WorkerRepository {
    private static final Deque<String> weekdayWorkers = new LinkedList<>();
    private static final Deque<String> holidayWorkers = new LinkedList<>();

    public static void registerWeekdayWorker(List<String> workers) {
        workers.forEach(weekdayWorkers::addLast);
    }

    public static void registerHolidayWorker(List<String> workers) {

    }

    public static void checkIsContainInWeekDaySequence(String holidayWorker) {
        if (!weekdayWorkers.contains(holidayWorker)) {
            throw new IllegalArgumentException(Error.INVALID_WORKER.getMessage());
        }
    }
}
