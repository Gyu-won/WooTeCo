package christmas.domain.entity;

import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orderMenus;
    private final Integer totalPrice;

    public Order(Map<Menu, Integer> orderMenus, Integer totalPrice) {
        this.orderMenus = orderMenus;
        this.totalPrice = totalPrice;
    }

    public EventReward calculateEventReward() {
        return null;
    }
}
