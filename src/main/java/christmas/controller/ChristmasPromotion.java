package christmas.controller;

import christmas.domain.entity.Order;
import christmas.domain.entity.VisitDate;
import christmas.domain.validation.OrderValidator;
import christmas.domain.validation.VisitDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasPromotion {
    public static void start() {
        OutputView.printStartMessage();

        VisitDate visitDate = new VisitDate(inputVisitDate());

        Order order = new Order(OrderValidator.validateAndReturn(InputView.readOrder()));
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
