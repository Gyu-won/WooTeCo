package christmas.controller;

import christmas.domain.entity.EventReward;
import christmas.domain.entity.Menu;
import christmas.domain.entity.OrderDetails;
import christmas.domain.service.validation.OrderValidator;
import christmas.domain.service.validation.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlanner {
    public static void run() {
        OutputView.printGreetingMessage();
        applyEvent(order());
    }

    private static OrderDetails order() {
        OrderDetails orderDetails = new OrderDetails(inputVisitDate(), inputOrderMenus());
        OutputView.printOrderDetails(orderDetails);
        return orderDetails;

    }

    private static void applyEvent(OrderDetails orderDetails) {
        EventReward eventReward = orderDetails.calculateEventReward();
        OutputView.printEventReward(eventReward);
        OutputView.printDiscountedPrice(orderDetails.applyEvent(eventReward));
    }


    private static Integer inputVisitDate() {
        try {
            return VisitDate.validate(InputView.inputVisitDate());
        } catch (IllegalArgumentException e) {
            InputView.printErrorMessage(e.getMessage());
            return inputVisitDate();
        }
    }

    private static Map<Menu, Integer> inputOrderMenus() {
        try {
            return OrderValidator.validate(InputView.inputOrderMenus());
        } catch (IllegalArgumentException e) {
            InputView.printErrorMessage(e.getMessage());
            return inputOrderMenus();
        }
    }
}
