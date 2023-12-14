package christmas.domain.validation;

import christmas.view.message.Error;

public class VisitDateValidator {
    private static final Integer LAST_DAY = 31;
    private static final Integer FIRST_DAY = 1;

    public static Integer validateAndReturn(String visitDate) {
        Integer parsedVisitDate = toInteger(visitDate);
        checkSmallerThanMinimumValue(parsedVisitDate);
        checkBiggerThanMaximumValue(parsedVisitDate);
        return parsedVisitDate;
    }

    private static void checkBiggerThanMaximumValue(Integer parsedVisitDate) {
        if (parsedVisitDate > LAST_DAY) {
            throw new IllegalArgumentException(Error.INVALID_VISIT_DATE.getMessage());
        }
    }

    private static void checkSmallerThanMinimumValue(Integer parsedVisitDate) {
        if (parsedVisitDate < FIRST_DAY) {
            throw new IllegalArgumentException(Error.INVALID_VISIT_DATE.getMessage());
        }
    }

    private static Integer toInteger(String visitDate) {
        try {
            return Integer.parseInt(visitDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_VISIT_DATE.getMessage());
        }
    }
}
