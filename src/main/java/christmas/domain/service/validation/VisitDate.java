package christmas.domain.service.validation;

import christmas.view.message.ErrorMessage;

public class VisitDate {
    private static final Integer MAXIMUM_RESERVATION_DEADLINE = 31;
    private static final Integer MINIMUM_RESERVATION_DEADLINE = 1;

    public static Integer validate(String visitDate) {
        return checkRange(toInteger(visitDate));
    }

    private static Integer checkRange(Integer parsedVisitDate) {
        if (isSmallerThanMin(parsedVisitDate) || isBiggerThanMax(parsedVisitDate)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DATE.getMessage());
        }
        return parsedVisitDate;
    }

    private static boolean isBiggerThanMax(Integer parsedVisitDate) {
        return parsedVisitDate > MAXIMUM_RESERVATION_DEADLINE;
    }

    private static boolean isSmallerThanMin(Integer parsedVisitDate) {
        return parsedVisitDate < MINIMUM_RESERVATION_DEADLINE;
    }

    private static Integer toInteger(String visitDate) {
        try {
            return Integer.parseInt(visitDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DATE.getMessage());
        }
    }
}
