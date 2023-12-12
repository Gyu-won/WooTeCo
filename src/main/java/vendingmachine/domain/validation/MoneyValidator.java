package vendingmachine.domain.validation;

import vendingmachine.view.message.Error;

public class MoneyValidator {

    public static Integer validateAndReturn(String money) {
        Integer parsedMoney = toInteger(money);
        if (다른 유효성검증 메서드) {
            throw new IllegalArgumentException(Error.MONEY.getMessage());
        }
        return parsedMoney;
    }

    private static Integer toInteger(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.MONEY.getMessage());
        }
    }

    private static boolean 다른유효성검증메서드명(타입 변수명) {
        return 조건;
    }
}
