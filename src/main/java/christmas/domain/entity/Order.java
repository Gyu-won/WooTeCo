package christmas.domain.entity;

import java.util.Map;
import java.util.Map.Entry;

public class Order {
    private final Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        this.order = order;
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public Integer calculatePrice() {
        int totalPrice = 0;
        for (Entry<String, Integer> entry : order.entrySet()) {
            Integer menuPrice = Menu.findPriceByName(entry.getKey());
            totalPrice += menuPrice * entry.getValue();
        }
        return totalPrice;
    }
}
