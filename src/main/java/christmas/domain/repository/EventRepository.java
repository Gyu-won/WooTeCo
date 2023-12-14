package christmas.domain.repository;

import christmas.domain.entity.ChristmasEvent;
import christmas.domain.entity.Order;
import christmas.domain.entity.VisitDate;
import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private static final Map<String, Integer> discountDetails = new HashMap<>();

    public static Map<String, Integer> applyGiftEvent(Order order) {
        if (order.calculatePrice() >= 120000) {
            discountDetails.put("GIFT", 25000);
        }
        return discountDetails;
    }

    public static void applyDiscountEvent(Order order, VisitDate visitDate) {
        if (order.calculatePrice() >= 10000) {
            applyChristmasEvent(order, visitDate);
        }
    }

    private static void applyChristmasEvent(Order order, VisitDate visitDate) {
        int discountPrice = ChristmasEvent.apply(order, visitDate);
    }
}
