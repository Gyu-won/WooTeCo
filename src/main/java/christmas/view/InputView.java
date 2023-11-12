package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.view.message.PromptMessage;

public class InputView {
    public static String inputVisitDate() {
        System.out.println(PromptMessage.VISIT_DATE.getMessage());
        return readLine();
    }

    public static String inputOrderMenus() {
        System.out.println(PromptMessage.ORDER_MENU.getMessage());
        return readLine();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
