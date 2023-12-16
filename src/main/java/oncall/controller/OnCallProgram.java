package oncall.controller;

import java.util.List;
import oncall.domain.validation.DateValidator;

public class OnCallProgram {
    public static void run() {
        List<String> monthAndWeekDay = DateValidator.splitToMonthAndWeekDay("5,월");
        DateValidator.validateAndReturnMonth(monthAndWeekDay.get(0));
    }
}
