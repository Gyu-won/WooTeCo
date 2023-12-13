package bridge.domain.validation;

import bridge.view.message.Error;

public class BridgeSizeValidator {

    public static int validateAndReturn(String bridgeSizeInput) {
        Integer parsedBridgeSize = toInteger(bridgeSizeInput);
        if (isSmallerThanMinimumSize(parsedBridgeSize) || isBiggerThanMaximumSize(parsedBridgeSize) {
            throw new IllegalArgumentException(Error.INVALID_BRIDGE_SIZE.getMessage());
        }
        return parsedBridgeSize;
    }

    private static boolean isBiggerThanMaximumSize(Integer parsedBridgeSize) {
        return parsedBridgeSize > 20;
    }

    private static boolean isSmallerThanMinimumSize(Integer parsedBridgeSize) {
        return parsedBridgeSize < 3;
    }

    private static Integer toInteger(String bridgeSizeInput) {
        try {
            return Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_BRIDGE_SIZE.getMessage());
        }
    }
}
