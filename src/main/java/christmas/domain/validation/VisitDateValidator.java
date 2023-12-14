package christmas.domain.validation;

import christmas.view.message.Error;

public class VisitDateValidator {
    public static Integer validateAndReturn(String visitDate) {
        Integer parsedVisitDate = toInteger(visitDate);

        return parsedVisitDate;
    }

    private static Integer toInteger(String visitDate) {
        try {
            return Integer.parseInt(visitDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_VISIT_DATE.getMessage());
        }
    }
}
