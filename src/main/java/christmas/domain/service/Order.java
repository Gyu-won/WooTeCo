package christmas.domain.service;

import christmas.domain.entity.Menu;
import java.util.Map;

public class Order {
    public static Integer calculateTotalPrice(Map<Menu, Integer> orderMenus) {
        return orderMenus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
