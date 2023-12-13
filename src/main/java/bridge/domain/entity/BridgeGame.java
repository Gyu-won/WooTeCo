package bridge.domain.entity;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private Integer tryCount;
    private BridgeGameResult gameResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        tryCount = 1;
        gameResult = new BridgeGameResult();
    }

    public BridgeGameResult move(Integer currentLocation, String moveBlock) {
        gameResult.add(currentLocation, moveBlock);
        gameResult.checkGameOver(currentLocation, bridge);
        return gameResult;
    }

    public void retry() {
        tryCount += 1;
        gameResult = new BridgeGameResult();
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public BridgeGameResult getGameResult() {
        return gameResult;
    }
}
