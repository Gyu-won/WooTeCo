package bridge.domain.validation;

import bridge.view.message.Error;

public class BridgeSizeValidator {

    public static int validateAndReturn(String bridgeSizeInput) {
        Integer parsedBridgeSize = toInteger(bridgeSizeInput);
        return parsedBridgeSize;
    }

    private static Integer toInteger(String bridgeSizeInput) {
        try {
            return Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_BRIDGE_SIZE.getMessage());
        }
    }
}
