package bridge.domain.validation;

import bridge.view.message.Error;

public class MoveBlockValidator {
    private static final String UPPER_BLOCK = "U";
    private static final String LOWER_BLOCK = "D";

    public static String validateAndReturn(String moveBlock) {
        if (!isValid(moveBlock)) {
            throw new IllegalArgumentException(Error.INVALID_MOVE_BLOCK.getMessage());
        }
        return moveBlock;
    }

    private static boolean isValid(String moveBlock) {
        return moveBlock.equals(UPPER_BLOCK) || moveBlock.equals(LOWER_BLOCK);
    }
}
