package christmas.domain.service.event;

import christmas.domain.entity.DayOfWeek;
import christmas.domain.entity.Menu;
import java.util.Map;

public class HolidayDiscount {
    private static final Integer HOLIDAY_DISCOUNT_AMOUNT = 2023;
    private static final Integer NO_DISCOUNT_AMOUNT = 0;

    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isHoliday(reserveDate);
    }

    public static Integer calculate(Map<Menu, Integer> orderItems) {
        return orderItems.entrySet().stream()
                .mapToInt(item -> calculateItemDiscount(item.getKey(), item.getValue()))
                .sum();
    }

    private static Integer calculateItemDiscount(Menu menu, Integer quantity) {
        if (menu.isMain()) {
            return HOLIDAY_DISCOUNT_AMOUNT * quantity;
        }
        return NO_DISCOUNT_AMOUNT;
    }
}
