package christmas.controller;

import christmas.domain.entity.EventReward;
import christmas.domain.entity.Menu;
import christmas.domain.entity.OrderDetails;
import christmas.domain.service.event.Badge;
import christmas.domain.service.validation.OrdersValidator;
import christmas.domain.service.validation.VisitDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlanner {
    public static void run() {
        OutputView.printGreetingMessage();
        applyEvent(order(reserveVisitDate()));
    }

    private static Integer reserveVisitDate() {
        try {
            return VisitDateValidator.validate(InputView.inputVisitDate());
        } catch (IllegalArgumentException e) {
            InputView.printErrorMessage(e.getMessage());
            return reserveVisitDate();
        }
    }

    private static OrderDetails order(Integer visitDate) {
        OrderDetails orderDetails = new OrderDetails(visitDate, inputOrders());
        OutputView.printOrderDetails(orderDetails);
        return orderDetails;
    }

    private static Map<Menu, Integer> inputOrders() {
        try {
            return OrdersValidator.validate(InputView.inputOrders());
        } catch (IllegalArgumentException e) {
            InputView.printErrorMessage(e.getMessage());
            return inputOrders();
        }
    }

    private static void applyEvent(OrderDetails orderDetails) {
        EventReward eventReward = orderDetails.calculateEventReward();
        OutputView.printEventReward(eventReward);
        OutputView.printDiscountedPrice(orderDetails.applyEvent(eventReward));
        OutputView.printBadge(Badge.assign(eventReward.sumEventRewards()));
    }
}
