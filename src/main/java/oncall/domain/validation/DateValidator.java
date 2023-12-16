package oncall.domain.validation;

import java.util.Arrays;
import java.util.List;

public class DateValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static List<String> splitToMonthAndWeekDay(String date) {
        return Arrays.asList(date.split(DELIMITER, SPLIT_LIMIT));
    }


}
