package bridge.view;

import bridge.domain.entity.BridgeGame;
import bridge.domain.entity.BridgeGameResult;
import bridge.view.message.Prompt;
import bridge.view.message.Result;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String UPPER_BLOCK = "U";
    private static final String LOWER_BLOCK = "D";
    private static final String MAP_DELIMITER = "|";
    private static final int INDEX_OFFSET = 1;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String BRIDGE_CROSS_SUCCESS = " O ";
    private static final String BRIDGE_CROSS_FAIL = " X ";
    private static final String BRIDGE_NOT_ATTEMPTED = "   ";

    public void printStartMessage() {
        System.out.println(Prompt.START.getMessage());
    }

    public void printMap(BridgeGameResult bridgeGameResult) {
        List<String> upperBlock = makeBlock(bridgeGameResult, UPPER_BLOCK);
        List<String> lowerBlock = makeBlock(bridgeGameResult, LOWER_BLOCK);
        System.out.println(Result.MAP.getMessage(String.join(MAP_DELIMITER, upperBlock)));
        System.out.println(Result.MAP.getMessage(String.join(MAP_DELIMITER, lowerBlock)));
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(Prompt.RESULT.getMessage());
        printMap(bridgeGame.getGameResult());
        System.out.println(Result.GAME_STATUS.getMessage(gameStatusToString(bridgeGame)));
        System.out.println(Result.NUMBER_OF_TRY.getMessage(toString(bridgeGame.getTryCount())));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private List<String> makeBlock(BridgeGameResult bridgeGameResult, String blockName) {
        List<String> block = new ArrayList<>();
        for (int index = 0; index < bridgeGameResult.getResult().size(); index++) {
            block.add(makeResultString(index, blockName, bridgeGameResult));
        }
        return block;
    }

    private String makeResultString(int index, String blockName, BridgeGameResult bridgeGameResult) {
        List<String> moveResults = bridgeGameResult.getResult();
        if (moveResults.get(index).equals(blockName)) {
            if (isLastIndex(index, moveResults) && bridgeGameResult.isGameOver()) {
                return BRIDGE_CROSS_FAIL;
            }
            return BRIDGE_CROSS_SUCCESS;
        }
        return BRIDGE_NOT_ATTEMPTED;
    }

    private boolean isLastIndex(int index, List<String> moveResults) {
        return index == moveResults.size() - INDEX_OFFSET;
    }

    private String gameStatusToString(BridgeGame bridgeGame) {
        BridgeGameResult bridgeGameResult = bridgeGame.getGameResult();
        if (bridgeGameResult.isGameOver()) {
            return FAIL;
        }
        return SUCCESS;
    }

    private String toString(Integer tryCont) {
        return Integer.toString(tryCont);
    }
}
