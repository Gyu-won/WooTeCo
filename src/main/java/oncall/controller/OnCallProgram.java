package oncall.controller;

import oncall.domain.validation.DateValidator;

public class OnCallProgram {
    public static void run() {
        DateValidator.splitToMonthAndWeekDay("5,월");
    }
}
