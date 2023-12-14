package christmas.controller;

import christmas.domain.entity.Order;
import christmas.domain.entity.VisitDate;
import christmas.domain.repository.EventRepository;
import christmas.domain.validation.OrderValidator;
import christmas.domain.validation.VisitDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasPromotion {
    public static void start() {
        OutputView.printStartMessage();

        VisitDate visitDate = new VisitDate(inputVisitDate());

        Order order = new Order(inputOrder());

        OutputView.printEventMessage(visitDate);

        OutputView.printOrder(order);

        OutputView.printTotalPriceBeforeDiscount(order.calculatePrice());

        OutputView.printGiftEvent(EventRepository.applyGiftEvent(order));

        OutputView.printAllEventDetails(EventRepository.applyDiscountEvent(order, visitDate));
    }

    private static Map<String, Integer> inputOrder() {
        try {
            return OrderValidator.validateAndReturn(InputView.readOrder());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return inputOrder();
        }
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
