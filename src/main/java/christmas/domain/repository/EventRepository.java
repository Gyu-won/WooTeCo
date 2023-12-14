package christmas.domain.repository;

import christmas.domain.entity.ChristmasEvent;
import christmas.domain.entity.Order;
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

    public static void applyDiscountEvent(Order order) {
        if (order.calculatePrice() >= 10000) {
            ChristmasEvent.apply(discountDetails);
        }
    }
}
