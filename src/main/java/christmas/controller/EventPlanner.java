package christmas.controller;

import christmas.domain.entity.Menu;
import christmas.domain.entity.OrderDetails;
import christmas.domain.service.validation.OrderValidator;
import christmas.domain.service.validation.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlanner {
    public static void run() {
        Integer visitDate = inputVisitDate();
        Map<Menu, Integer> orderMenus = inputOrderMenus();
        OrderDetails orderDetails = new OrderDetails(visitDate, orderMenus);
        OutputView.printOrderDetails(orderDetails);
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
