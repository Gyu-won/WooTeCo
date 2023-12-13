package bridge.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {

    private boolean isGameOver = false;
    private boolean isGameClear = false;
    private final Map<Integer, String> result = new HashMap<>();

    public void add(Integer currentLocation, String moveBlock) {
        result.put(currentLocation, moveBlock);
    }

    public void checkGameOver(Integer currentLocation, List<String> bridge) {
        if (!result.get(currentLocation).equals(bridge.get(currentLocation - 1))) {
            isGameOver = true;
        }
    }

    public void checkGameClear(List<String> bridge) {
        if (!isGameOver && bridge.size() == result.size()) {
            isGameClear = true;
        }
    }
}
