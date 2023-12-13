package bridge.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {

    private boolean isGameOver = false;
    private final List<String> result = new ArrayList<>();

    public void add(Integer currentLocation, String moveBlock) {
        result.add(moveBlock);
    }

    public void checkGameOver(Integer currentLocation, List<String> bridge) {
        if (!result.get(currentLocation).equals(bridge.get(currentLocation))) {
            isGameOver = true;
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public List<String> getResult() {
        return result;
    }
}
