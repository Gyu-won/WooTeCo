package bridge.domain.validation;

import bridge.view.message.Error;

public class BridgeSizeValidator {
    private static final Integer MAXIMUM_SIZE = 20;
    private static final Integer MINIMUM_SIZE = 3;

    public static int validateAndReturn(String bridgeSizeInput) {
        Integer parsedBridgeSize = toInteger(bridgeSizeInput);
        if (isValidSize(parsedBridgeSize)) {
            throw new IllegalArgumentException(Error.INVALID_BRIDGE_SIZE.getMessage());
        }
        return parsedBridgeSize;
    }

    private static Integer toInteger(String bridgeSizeInput) {
        try {
            return Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    private static boolean isValidSize(Integer parsedBridgeSize) {
        return isSmallerThanMinimumSize(parsedBridgeSize) || isBiggerThanMaximumSize(parsedBridgeSize);
    }

    private static boolean isBiggerThanMaximumSize(Integer parsedBridgeSize) {
        return parsedBridgeSize > MAXIMUM_SIZE;
    }

    private static boolean isSmallerThanMinimumSize(Integer parsedBridgeSize) {
        return parsedBridgeSize < MINIMUM_SIZE;
    }
}
