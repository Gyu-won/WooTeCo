package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.entity.BridgeGame;
import bridge.domain.entity.BridgeMaker;
import bridge.domain.validation.BridgeSizeValidator;
import bridge.domain.validation.MoveBlockValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    public static void run(InputView inputView, OutputView outputView) {

        int bridgeSize = BridgeSizeValidator.validateAndReturn(inputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));

        for (int currentLocation = 1; currentLocation <= bridgeSize; currentLocation++) {
            String block = MoveBlockValidator.validateAndReturn(inputView.readMoving());
            bridgeGame.move(currentLocation, block);
        }

    }
}
