package bridge.controller;

import bridge.domain.validation.MoveBlockValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    public static void run(InputView inputView, OutputView outputView) {
        String moveBlock = MoveBlockValidator.validateAndReturn(inputView.readMoving());
    }
}
