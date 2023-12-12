package vendingmachine.domain.validation;

import vendingmachine.view.message.Error;

public class MoneyValidator {

    private static final Integer MONEY_DIVISOR = 10;
    private static final int NO_REMAINDER = 0;
    private static final Integer MINIMUM_VALID_MONEY = 0;

    public static Integer validateAndReturn(String money) {
        Integer parsedMoney = toInteger(money);
        checkBiggerOrEqualThanZero(parsedMoney);
        checkDivisibleByTen(parsedMoney);
        return parsedMoney;
    }

    private static void checkDivisibleByTen(Integer parsedMoney) {
        if (parsedMoney % MONEY_DIVISOR != NO_REMAINDER) {
            throw new IllegalArgumentException(Error.MONEY_INPUT.getMessage());
        }
    }

    private static void checkBiggerOrEqualThanZero(Integer parsedMoney) {
        if (parsedMoney < MINIMUM_VALID_MONEY) {
            throw new IllegalArgumentException(Error.MONEY_INPUT.getMessage());
        }
    }

    private static Integer toInteger(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.MONEY_INPUT.getMessage());
        }
    }
}
