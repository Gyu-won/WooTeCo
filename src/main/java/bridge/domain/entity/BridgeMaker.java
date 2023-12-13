package bridge.domain.entity;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    //인스턴스 변수 변경 불가
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(convertBridgeNumberToBlock(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String convertBridgeNumberToBlock(int bridgeNumber) {
        if (bridgeNumber == 0) {
            return "D";
        }
        return "U";
    }
}
