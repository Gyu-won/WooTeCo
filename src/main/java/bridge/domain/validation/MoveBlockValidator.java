package bridge.domain.validation;

import bridge.view.message.Error;

public class MoveBlockValidator {
    public static String validateAndReturn(String moveBlock) {
        if (!isValid(moveBlock)) {
            throw new IllegalArgumentException(Error.INVALID_MOVE_VLOCK.getMessage());
        }
        return moveBlock;
    }

    private static boolean isValid(String moveBlock) {
        return moveBlock.equals("U") || moveBlock.equals("D");
    }
}
