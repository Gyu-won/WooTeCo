package vendingmachine.controller;

import vendingmachine.domain.validation.MoneyValidator;
import vendingmachine.view.InputView;

public class VendingMachine {
    public static void run() {
        MoneyValidator.validateAndReturn(InputView.inputMachineMoney());
    }
}
