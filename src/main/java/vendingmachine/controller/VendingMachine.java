package vendingmachine.controller;

import vendingmachine.domain.entity.CoinRepository;
import vendingmachine.domain.entity.MenuRepository;
import vendingmachine.domain.entity.Money;
import vendingmachine.domain.validation.MoneyValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    public static void run() {
        OutputView.printCoin(CoinRepository.generate(inputMoney()));
        inputMenu();

        Money money = new Money(inputInsertedMoney());

        OutputView.printLeftMoney(money);
        MenuRepository.buy(InputView.inputMenuNameToBuy(), money);

    }

    private static Integer inputInsertedMoney() {
        try {
            return MoneyValidator.validateAndReturn(InputView.inputInsertedMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return inputMoney();
        }
    }

    private static void inputMenu() {
        try {
            MenuRepository.create(InputView.inputMenu());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            inputMenu();
        }
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
