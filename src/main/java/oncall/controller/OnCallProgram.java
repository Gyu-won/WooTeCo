package oncall.controller;

import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.Weekday;
import oncall.domain.validation.DateValidator;
import oncall.domain.validation.WorkerValidator;
import oncall.view.OutputView;

public class OnCallProgram {
    public static void run() {
        Calender calender = createCalender();
        inputWeekdayWorker();
    }

    private static List<String> inputWeekdayWorker() {
        try {
            List<String> workers = WorkerValidator.validateAndReturn("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return inputWeekdayWorker();
        }

    }

    private static Calender createCalender() {
        try {
            List<String> monthAndWeekDay = DateValidator.splitToMonthAndWeekDay("5,월");
            Integer month = DateValidator.validateAndReturnMonth(monthAndWeekDay.get(0));
            Weekday weekday = DateValidator.validateAndReturnWeekday(monthAndWeekDay.get(1));
            return new Calender(month, weekday);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return createCalender();
        }

    }
}
