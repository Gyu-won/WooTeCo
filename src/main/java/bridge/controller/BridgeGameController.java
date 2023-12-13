package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.entity.BridgeMaker;
import bridge.domain.validation.BridgeSizeValidator;
import bridge.domain.validation.MoveBlockValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    public static void run(InputView inputView, OutputView outputView) {

        int bridgeSize = BridgeSizeValidator.validateAndReturn(inputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeMaker.makeBridge(bridgeSize);

        String moveBlock = MoveBlockValidator.validateAndReturn(inputView.readMoving());
    }
}
