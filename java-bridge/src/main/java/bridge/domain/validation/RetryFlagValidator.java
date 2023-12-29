package bridge.domain.validation;

import bridge.view.message.Error;

public class RetryFlagValidator {
    private static final String RETRY_FLAG = "R";
    private static final String QUIT_FLAG = "Q";

    public static String validateAndReturn(String retryFlag) {
        if (!isValid(retryFlag)) {
            throw new IllegalArgumentException(Error.INVALID_MOVE_BLOCK.getMessage());
        }
        return retryFlag;
    }

    private static boolean isValid(String retryFlag) {
        return retryFlag.equals(RETRY_FLAG) || retryFlag.equals(QUIT_FLAG);
    }
}
