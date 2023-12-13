package bridge.domain.entity;

import java.util.List;

public class BridgeGame {
    private static final Integer INITIAL_COUNT_VALUE = 0;
    private static final Integer INCREASE_AMOUNT = 1;

    private final List<String> bridge;
    private Integer tryCount;
    private BridgeGameResult gameResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        tryCount = INITIAL_COUNT_VALUE;
        gameResult = new BridgeGameResult();
    }

    public BridgeGameResult move(Integer currentLocation, String moveBlock) {
        gameResult.add(currentLocation, moveBlock);
        gameResult.checkGameOver(currentLocation, bridge);
        return gameResult;
    }

    public void retry() {
        tryCount += INCREASE_AMOUNT;
        gameResult = new BridgeGameResult();
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public BridgeGameResult getGameResult() {
        return gameResult;
    }
}
