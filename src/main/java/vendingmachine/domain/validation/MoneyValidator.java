package vendingmachine.domain.validation;

import vendingmachine.view.message.Error;

public class MoneyValidator {

    public static Integer validateAndReturn(String money) {
        Integer parsedMoney = toInteger(money);
        checkBiggerOrEqualThanZero(parsedMoney);
        checkDivisibleByTen(parsedMoney);
        return parsedMoney;
    }

    private static void checkDivisibleByTen(Integer parsedMoney) {
        if (parsedMoney % 10 != 0) {
            throw new IllegalArgumentException(Error.MONEY.getMessage());
        }
    }

    private static void checkBiggerOrEqualThanZero(Integer parsedMoney) {
        if (parsedMoney < 0) {
            throw new IllegalArgumentException(Error.MONEY.getMessage());
        }
    }

    private static Integer toInteger(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.MONEY.getMessage());
        }
    }
}
