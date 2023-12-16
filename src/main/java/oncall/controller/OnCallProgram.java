package oncall.controller;

import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.Weekday;
import oncall.domain.validation.DateValidator;

public class OnCallProgram {
    public static void run() {
        List<String> monthAndWeekDay = DateValidator.splitToMonthAndWeekDay("5,월");
        Integer month = DateValidator.validateAndReturnMonth(monthAndWeekDay.get(0));
        Weekday weekday = DateValidator.validateAndReturnWeekday(monthAndWeekDay.get(1));
        Calender calender = new Calender(month, weekday);
    }
}
