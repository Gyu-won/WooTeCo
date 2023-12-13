package bridge.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {

    private boolean isGameOver = false;
    private boolean isGameClear = false;
    private final List<String> result = new ArrayList<>();

    public void add(Integer currentLocation, String moveBlock) {
        result.add(moveBlock);
    }

    public void checkGameOver(Integer currentLocation, List<String> bridge) {
        if (!result.get(currentLocation).equals(bridge.get(currentLocation))) {
            isGameOver = true;
        }
    }

    public void checkGameClear(List<String> bridge) {
        if (!isGameOver && bridge.size() == result.size()) {
            isGameClear = true;
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isGameClear() {
        return isGameClear;
    }

    public List<String> getResult() {
        return result;
    }
}
