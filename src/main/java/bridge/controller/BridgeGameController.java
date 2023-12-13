package bridge.controller;

import bridge.domain.validation.BridgeSizeValidator;
import bridge.domain.validation.MoveBlockValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    public static void run(InputView inputView, OutputView outputView) {

        int bridgeSize = BridgeSizeValidator.validateAndReturn(inputView.readBridgeSize());

        String moveBlock = MoveBlockValidator.validateAndReturn(inputView.readMoving());
    }
}
