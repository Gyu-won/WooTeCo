package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import vendingmachine.view.message.Prompt;

public class InputView {
    public static String inputMachineMoney() {
        System.out.println(Prompt.MachineMoneyInput.getMessage());
        return readLine();
    }
}