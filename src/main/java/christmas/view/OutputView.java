package christmas.view;

import christmas.view.message.Prompt;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printStartMessage() {
        System.out.println(Prompt.START.getMessage());
    }
}