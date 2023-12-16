package oncall.domain.validation;

import java.util.Arrays;
import java.util.List;
import oncall.domain.entity.Month;
import oncall.view.message.Error;

public class DateValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";
    private static final List<String> weekdays = List.of("월", "화", "수", "목", "금", "토", "일");

    public static List<String> splitToMonthAndWeekDay(String date) {
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

    public static String validateAndReturnWeekday(String weekday) {
        if (weekdays.contains(weekday)) {
            return weekday;
        }
        throw new IllegalArgumentException(Error.INVALID_DATE.getMessage());
    }
}
