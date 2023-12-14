package christmas.domain.validation;

import christmas.view.message.Error;

public class VisitDateValidator {
    public static Integer validateAndReturn(String visitDate) {
        Integer parsedVisitDate = toInteger(visitDate);
        checkSmallerThanMinimumValue(parsedVisitDate);
        checkBiggerThanMaximumValue(parsedVisitDate);
        return parsedVisitDate;
    }

    private static void checkBiggerThanMaximumValue(Integer parsedVisitDate) {
        if (parsedVisitDate > 31) {
            throw new IllegalArgumentException(Error.INVALID_VISIT_DATE.getMessage());
        }
    }

    private static void checkSmallerThanMinimumValue(Integer parsedVisitDate) {
        if (parsedVisitDate < 1) {
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
