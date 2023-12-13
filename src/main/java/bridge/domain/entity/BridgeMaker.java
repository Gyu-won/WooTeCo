package bridge.domain.entity;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final Integer INITIAL_POSITION = 0;
    private static final int UPPER_VALUE = 1;
    private static final String UP = "U";
    private static final String DOWN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int position = INITIAL_POSITION; position < size; position++) {
            bridge.add(convertBridgeNumberToBridge(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String convertBridgeNumberToBridge(int bridgeNumber) {
        if (isUpperBridge(bridgeNumber)) {
            return UP;
        }
        return DOWN;
    }

    private boolean isUpperBridge(int bridgeNumber) {
        return bridgeNumber == UPPER_VALUE;
    }
}
