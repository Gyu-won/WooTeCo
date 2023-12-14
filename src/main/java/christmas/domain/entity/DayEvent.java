package christmas.domain.entity;

import java.util.Map.Entry;

public class DayEvent {
    private static final Integer DAY_OF_WEEK = 7;
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    private static final int INITIAL_DISCOUNT = 0;
    private static final int DISCOUNT_AMOUNT = 2023;

    public static boolean applicableHolidayEvent(VisitDate visitDate) {
        int weekday = visitDate.getVisitDate() % DAY_OF_WEEK;
        return weekday == FRIDAY || weekday == SATURDAY;
    }

    public static Integer applyHoliday(Order order) {
        int totalDiscount = INITIAL_DISCOUNT;
        for (Entry<String, Integer> entry : order.getOrder().entrySet()) {
            if (Menu.isMain(entry.getKey())) {
                totalDiscount += DISCOUNT_AMOUNT * entry.getValue();
            }
        }
        return totalDiscount;
    }

    public static Integer applyWeekday(Order order) {
        int totalDiscount = INITIAL_DISCOUNT;
        for (Entry<String, Integer> entry : order.getOrder().entrySet()) {
            if (Menu.isDessert(entry.getKey())) {
                totalDiscount += DISCOUNT_AMOUNT * entry.getValue();
            }
        }
        return totalDiscount;
    }
}
