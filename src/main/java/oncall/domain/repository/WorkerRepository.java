package oncall.domain.repository;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class WorkerRepository {
    private static final Deque<String> weekdayWorkers = new LinkedList<>();
    private static final Deque<String> holidayWorkers = new LinkedList<>();

    public static void registerWeekdayWorker(List<String> workers) {
        workers.forEach(weekdayWorkers::addLast);
    }
}
