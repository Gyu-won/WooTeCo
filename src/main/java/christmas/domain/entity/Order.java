package christmas.domain.entity;

import java.util.Map;

public class Order {
    private final Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        this.order = order;
    }
}
