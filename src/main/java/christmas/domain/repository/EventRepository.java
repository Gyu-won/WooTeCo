package christmas.domain.repository;

import christmas.domain.entity.Order;
import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private static final Map<String, Integer> discountDetails = new HashMap<>();

    public static void applyGiftEvent(Order order) {
        if (order.calculatePrice() >= 120000) {
            discountDetails.put("GIFT", 25000);
        }
    }
}
