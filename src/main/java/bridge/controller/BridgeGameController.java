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

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void run() {

        int bridgeSize = BridgeSizeValidator.validateAndReturn(inputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));

        gameStart(bridgeSize, bridgeGame);

    }

    private static void gameStart(int bridgeSize, BridgeGame bridgeGame) {
        for (int currentLocation = 0; currentLocation < bridgeSize; currentLocation++) {
            String block = MoveBlockValidator.validateAndReturn(inputView.readMoving());
            BridgeGameResult bridgeGameResult = bridgeGame.move(currentLocation, block);
            outputView.printMap(bridgeGameResult);
            if (bridgeGameResult.isGameOver()) {
                retryOrExit(bridgeSize, bridgeGame);
                break;
            }
        }
    }

    private static void retryOrExit(int bridgeSize, BridgeGame bridgeGame) {
        if (isRetry(askForRetry())) {
            bridgeGame.retry();
            gameStart(bridgeSize, bridgeGame);
        }
    }

    private static String askForRetry() {
        return RetryFlagValidator.validateAndReturn(inputView.readGameCommand());
    }

    private static boolean isRetry(String retryFlag) {
        return retryFlag.equals("R");
    }
}
