package bridge.domain.entity;

import java.util.List;

public class BridgeGame {
    private static final Integer INITIAL_COUNT_VALUE = 1;
    private static final Integer INCREASE_AMOUNT = 1;

    private final List<String> bridge;
    private Integer tryCount;
    private BridgeGameResult gameResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        tryCount = INITIAL_COUNT_VALUE;
        gameResult = new BridgeGameResult();
    }

    public BridgeGameResult move(String moveBlock) {
        gameResult.add(moveBlock);
        gameResult.checkGameOver(bridge);
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
