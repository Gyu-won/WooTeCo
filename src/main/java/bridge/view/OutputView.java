package bridge.view;

import bridge.domain.entity.BridgeGame;
import bridge.domain.entity.BridgeGameResult;
import bridge.view.message.Prompt;
import bridge.view.message.Result;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printStartMessage() {
        System.out.println(Prompt.START.getMessage());
    }

    public void printMap(BridgeGameResult bridgeGameResult) {
        List<String> upperBlock = makeBlock(bridgeGameResult, "U");
        List<String> lowerBlock = makeBlock(bridgeGameResult, "D");
        System.out.println(Result.MAP.getMessage(String.join("|", upperBlock)));
        System.out.println(Result.MAP.getMessage(String.join("|", lowerBlock)));
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

    private String makeResultString(int index, String blockName, BridgeGameResult bridgeGameResult) {
        List<String> moveResults = bridgeGameResult.getResult();
        if (moveResults.get(index).equals(blockName)) {
            if (index == moveResults.size() - 1 && bridgeGameResult.isGameOver()) {
                return " X ";
            }
            return " O ";
        }
        return "   ";
    }

    private List<String> makeBlock(BridgeGameResult bridgeGameResult, String blockName) {
        List<String> block = new ArrayList<>();
        for (int index = 0; index < bridgeGameResult.getResult().size(); index++) {
            block.add(makeResultString(index, blockName, bridgeGameResult));
        }
        return block;
    }

    private String toString(Integer tryCont) {
        return Integer.toString(tryCont);
    }

    private String gameStatusToString(BridgeGame bridgeGame) {
        BridgeGameResult bridgeGameResult = bridgeGame.getGameResult();
        if (bridgeGameResult.isGameOver()) {
            return "실패";
        }
        return "성공";
    }
}
