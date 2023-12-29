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
        int currentPosition = result.size() - INDEX_OFFSET;
        if (!canPass(currentPosition, bridge)) {
            isGameOver = true;
        }
    }

    private boolean canPass(int currentPosition, List<String> bridge) {
        return result.get(currentPosition).equals(bridge.get(currentPosition));
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public List<String> getResult() {
        return result;
    }
}
