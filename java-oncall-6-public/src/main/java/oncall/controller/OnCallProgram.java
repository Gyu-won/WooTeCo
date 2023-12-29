package oncall.controller;

import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.Weekday;
import oncall.domain.repository.WorkerRepository;
import oncall.domain.validation.DateValidator;
import oncall.domain.validation.WorkerValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallProgram {
    public static void run() {
        createCalender();
        registerWorker();
        WorkerRepository.createTimeTable();
        OutputView.printTimeTable();
    }

    private static void registerWorker() {
        try {
            List<String> weekdayWorkerNames = WorkerValidator.validateAndReturn(InputView.readWeekdayWorkers());
            List<String> holidayWorkerNames = WorkerValidator.validateAndReturn(InputView.readHolidayWorkers());
            WorkerRepository.checkIsSame(weekdayWorkerNames, holidayWorkerNames);
            WorkerRepository.registerWorker(weekdayWorkerNames, holidayWorkerNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            registerWorker();
        }
    }

    private static void createCalender() {
        try {
            List<String> monthAndWeekDay = DateValidator.validateAndReturn(InputView.readMonthAndWeekday());
            Integer month = DateValidator.validateAndReturnMonth(monthAndWeekDay.get(0));
            Weekday weekday = DateValidator.validateAndReturnWeekday(monthAndWeekDay.get(1));
            Calender.create(month, weekday);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            createCalender();
        }
    }
}
