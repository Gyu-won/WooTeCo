package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.entity.BridgeGame;
import bridge.domain.entity.BridgeGameResult;
import bridge.domain.entity.BridgeMaker;
import bridge.domain.validation.BridgeSizeValidator;
import bridge.domain.validation.MoveBlockValidator;
import bridge.domain.validation.RetryFlagValidator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void run() {
        outputView.printStartMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        start(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    private static int inputBridgeSize() {
        try {
            return BridgeSizeValidator.validateAndReturn(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return inputBridgeSize();
        }
    }

    private static void start(BridgeGame bridgeGame) {
        int bridgeSize = bridgeGame.getBridgeSize();
        for (int currentLocation = 0; currentLocation < bridgeSize; currentLocation++) {
            String block = inputMoveBlock();
            BridgeGameResult bridgeGameResult = bridgeGame.move(currentLocation, block);
            outputView.printMap(bridgeGameResult);
            if (bridgeGameResult.isGameOver()) {
                retryOrExit(bridgeGame);
                break;
            }
        }
    }

    private static String inputMoveBlock() {
        try {
            return MoveBlockValidator.validateAndReturn(inputView.readMoving());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return inputMoveBlock();
        }
    }

    private static void retryOrExit(BridgeGame bridgeGame) {
        if (isRetry(askForRetry())) {
            bridgeGame.retry();
            start(bridgeGame);
        }
    }

    private static boolean isRetry(String retryFlag) {
        return retryFlag.equals("R");
    }

    private static String askForRetry() {
        return RetryFlagValidator.validateAndReturn(inputView.readGameCommand());
    }
}
