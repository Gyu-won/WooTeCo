package christmas.domain.service.event;

import christmas.domain.entity.DayOfWeek;
import christmas.domain.entity.Menu;
import java.util.Map;

public class WeekdayDiscount {
    private static final Integer WEEKDAY_DISCOUNT_AMOUNT = 2023;
    private static final Integer NO_DISCOUNT_AMOUNT = 0;

    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isWeekday(reserveDate);
    }

    public static Integer calculate(Map<Menu, Integer> orderItems) {
        return orderItems.entrySet().stream()
                .mapToInt(item -> calculateItemDiscount(item.getKey(), item.getValue()))
                .sum();
    }

    private static Integer calculateItemDiscount(Menu menu, Integer quantity) {
        if (menu.isDessert()) {
            return WEEKDAY_DISCOUNT_AMOUNT * quantity;
        }
        return NO_DISCOUNT_AMOUNT;
    }
}