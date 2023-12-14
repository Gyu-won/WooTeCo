package christmas.view;

import christmas.domain.entity.VisitDate;
import christmas.view.message.Prompt;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printStartMessage() {
        System.out.println(Prompt.START.getMessage());
    }

    public static void printEventMessage(VisitDate visitDate) {
        System.out.printf(Prompt.EVENT.getMessage(), visitDate.getVisitDate());
    }
}