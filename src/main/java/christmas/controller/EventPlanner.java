package christmas.controller;

import christmas.domain.service.validation.VisitDate;
import christmas.view.InputView;

public class EventPlanner {
    public static void run() {
        Integer visitDate = inputVisitDate();
        String orderMenus = InputView.inputOrderMenus();
    }

    private static Integer inputVisitDate() {
        try {
            return VisitDate.validate(InputView.inputVisitDate());
        } catch (IllegalArgumentException e) {
            InputView.printErrorMessage(e.getMessage());
            return inputVisitDate();
        }
    }
}
