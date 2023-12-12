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

        while (MenuRepository.purchaseAvailable(money)) {
            purchaseProduct(money);
        }

        OutputView.printLeftMoney(money);
        OutputView.printExchange(CoinRepository.calculateExchange(money));
    }

    private static void purchaseProduct(Money money) {
        try {
            OutputView.printLeftMoney(money);
            MenuRepository.buy(InputView.inputMenuNameToBuy(), money);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            purchaseProduct(money);
        }
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
