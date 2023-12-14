package christmas.controller;

import christmas.domain.validation.VisitDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasPromotion {
    public static void start() {
        OutputView.printStartMessage();

        Integer visitDate = inputVisitDate();
    }

    private static Integer inputVisitDate() {
        try {
            return VisitDateValidator.validateAndReturn(InputView.readVisitDate());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return inputVisitDate();
        }
    }
}
