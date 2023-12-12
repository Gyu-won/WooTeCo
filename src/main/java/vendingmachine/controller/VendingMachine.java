package vendingmachine.controller;

import vendingmachine.domain.entity.CoinRepository;
import vendingmachine.domain.validation.MoneyValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    public static void run() {
        OutputView.printCoin(CoinRepository.generate(inputMoney()));
    }

    private static Integer inputMoney() {
        try {
            return MoneyValidator.validateAndReturn(InputView.inputMachineMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return inputMoney();
        }
    }
}
