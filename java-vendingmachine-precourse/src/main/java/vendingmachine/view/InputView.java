package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import vendingmachine.view.message.Prompt;

public class InputView {
    public static String inputMachineMoney() {
        System.out.println(Prompt.MACHINE_MONEY_INPUT.getMessage());
        return readLine();
    }

    public static String inputMenu() {
        System.out.println(Prompt.MENU_INPUT.getMessage());
        return readLine();
    }

    public static String inputInsertedMoney() {
        System.out.println(Prompt.INSERT_MONEY_INPUT.getMessage());
        return readLine();
    }

    public static String inputMenuNameToBuy() {
        System.out.println(Prompt.PURCHASE_INPUT.getMessage());
        return readLine();
    }
}