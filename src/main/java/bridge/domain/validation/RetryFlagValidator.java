package bridge.domain.validation;

import bridge.view.message.Error;

public class RetryFlagValidator {
    public static String validateAndReturn(String retryFlag) {
        if (!isValid(retryFlag)) {
            throw new IllegalArgumentException(Error.INVALID_MOVE_VLOCK.getMessage());
        }
        return retryFlag;
    }

    private static boolean isValid(String retryFlag) {
        return retryFlag.equals("R") || retryFlag.equals("Q");
    }
}
