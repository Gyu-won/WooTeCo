package oncall.controller;

import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.Weekday;
import oncall.domain.validation.DateValidator;
import oncall.view.OutputView;

public class OnCallProgram {
    public static void run() {
        Calender calender = createCalender();
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
