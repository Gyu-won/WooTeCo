package oncall.controller;

import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.Weekday;
import oncall.domain.repository.WorkerRepository;
import oncall.domain.validation.DateValidator;
import oncall.domain.validation.WorkerValidator;
import oncall.view.OutputView;

public class OnCallProgram {
    public static void run() {
        createCalender();
        inputWeekdayWorker();
        registerHolidayWorker();
        WorkerRepository.createTimeTable();
    }

    private static void registerHolidayWorker() {
        try {
            List<String> workerNames = WorkerValidator.validateAndReturn("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");
            WorkerRepository.checkIsSameWithWeekdayWorker(workerNames);
            WorkerRepository.registerHolidayWorker(workerNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            registerHolidayWorker();
        }
    }

    private static void inputWeekdayWorker() {
        try {
            List<String> workerNames = WorkerValidator.validateAndReturn("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
            WorkerRepository.registerWeekdayWorker(workerNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            inputWeekdayWorker();
        }
    }

    private static void createCalender() {
        try {
            List<String> monthAndWeekDay = DateValidator.splitToMonthAndWeekDay("5,월");
            Integer month = DateValidator.validateAndReturnMonth(monthAndWeekDay.get(0));
            Weekday weekday = DateValidator.validateAndReturnWeekday(monthAndWeekDay.get(1));
            Calender.create(month, weekday);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            createCalender();
        }
    }
}
