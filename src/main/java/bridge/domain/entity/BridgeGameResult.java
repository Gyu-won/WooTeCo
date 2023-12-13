package bridge.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {
    private static final Integer INDEX_OFFSET = 1;

    private boolean isGameOver = false;
    private final List<String> result = new ArrayList<>();

    public void add(String moveBlock) {
        result.add(moveBlock);
    }

    public void checkGameOver(List<String> bridge) {
        int currentLocation = result.size() - INDEX_OFFSET;
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
