package christmas.domain;

import java.util.Map;

public class WeekDayDiscount {

    private static final Integer WEEKDAY_DISCOUNT_AMOUNT = 2023;
    private static final Integer NO_DISCOUNT_AMOUNT = 0;

    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isWeekday(calculateDayOfWeek(reserveDate));
    }

    public static Integer calculate(Map<Menu, Integer> orderItems) {
        return orderItems.entrySet().stream()
                .mapToInt(item -> calculateItemDiscount(item.getKey(), item.getValue()))
                .sum();
    }

    private static Integer calculateDayOfWeek(Integer reserveDate) {
        return reserveDate % DayOfWeek.DAYS_IN_WEEK;
    }

    private static Integer calculateItemDiscount(Menu menu, Integer quantity) {
        if (menu.isDessert()) {
            return WEEKDAY_DISCOUNT_AMOUNT * quantity;
        }
        return NO_DISCOUNT_AMOUNT;
    }
}