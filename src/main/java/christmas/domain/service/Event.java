package christmas.domain.service;

import christmas.domain.entity.Menu;
import java.util.Map;

public class Event {
    private static final Integer NO_DISCOUNT = 0;

    public static Integer applyGiftEvent(Integer totalOrderAmount) {
        if (GiftEvent.isApplicable(totalOrderAmount)) {
            return Menu.calculateGiftPrice();
        }
        return NO_DISCOUNT;
    }

    public static Integer applyChristmasDiscount(Integer reserveDate) {
        if (ChristmasDiscount.isWithinPeriod(reserveDate)) {
            return ChristmasDiscount.calculate(reserveDate);
        }
        return NO_DISCOUNT;
    }

    public static Integer applyWeekdayDiscount(Map<Menu, Integer> orderItems, Integer reserveDate) {
        if (WeekdayDiscount.isWithinPeriod(reserveDate)) {
            return WeekdayDiscount.calculate(orderItems);
        }
        return NO_DISCOUNT;
    }

    public static Integer applyHolidayDiscount(Map<Menu, Integer> orderItems, Integer reserveDate) {
        if (HolidayDiscount.isWithinPeriod(reserveDate)) {
            return HolidayDiscount.calculate(orderItems);
        }
        return NO_DISCOUNT;
    }

    public static Integer applySpecialDiscount(Integer reserveDate) {
        if (SpecialDiscount.isWithinPeriod(reserveDate)) {
            return SpecialDiscount.AMOUNT;
        }
        return NO_DISCOUNT;
    }
}
