package oncall.domain.validation;

import java.util.Arrays;
import java.util.List;
import oncall.domain.entity.Month;
import oncall.domain.entity.Weekday;
import oncall.view.message.Error;

public class DateValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static List<String> validateAndReturn(String monthAndWeekday) {
        List<String> monthAndWeekdays = splitToMonthAndWeekDay(monthAndWeekday);
        checkSize(monthAndWeekdays);
        return monthAndWeekdays;
    }

    private static void checkSize(List<String> monthAndWeekdays) {
        if (monthAndWeekdays.size() < 2) {
            throw new IllegalArgumentException(Error.INVALID_DATE.getMessage());
        }
    }

    private static List<String> splitToMonthAndWeekDay(String date) {
        return Arrays.asList(date.split(DELIMITER, SPLIT_LIMIT));
    }

    public static Integer validateAndReturnMonth(String month) {
        Integer parsedMonth = toInteger(month);
        checkIsValid(parsedMonth);
        return parsedMonth;
    }

    private static void checkIsValid(Integer parsedMonth) {
        if (!Month.isExist(parsedMonth)) {
            throw new IllegalArgumentException(Error.INVALID_DATE.getMessage());
        }
    }

    private static Integer toInteger(String month) {
        try {
            return Integer.parseInt(month);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_DATE.getMessage());
        }
    }

    public static Weekday validateAndReturnWeekday(String weekday) {
        return new Weekday(weekday);
    }
}
