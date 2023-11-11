package christmas.domain;

import java.util.Map;

public class Event {
    private static final Integer NO_DISCOUNT = 0;

    public static Integer applyGiftEvent(Integer totalOrderAmount) {
        if (GiftEvent.isApplicable(totalOrderAmount)) {
            return Menu.calculateGiftPrice();
        }
        return NO_DISCOUNT;
    }

    public static Integer applyDiscountEvent(Map<Menu, Integer> orderItems, Integer reserveDate) {
        Integer totalDiscount = applyChristmasDiscount(reserveDate);
        totalDiscount += applyWeekdayDiscount(orderItems, reserveDate);
        totalDiscount += applyHolidayDiscount(orderItems, reserveDate);
        totalDiscount += applySpecialDiscount(reserveDate);
        return totalDiscount;
    }

    private static Integer applyChristmasDiscount(Integer reserveDate) {
        if (ChristmasDiscount.isWithinPeriod(reserveDate)) {
            return ChristmasDiscount.calculate(reserveDate);
        }
        return NO_DISCOUNT;
    }

    private static Integer applyWeekdayDiscount(Map<Menu, Integer> orderItems, Integer reserveDate) {
        if (WeekdayDiscount.isWithinPeriod(reserveDate)) {
            return WeekdayDiscount.calculate(orderItems);
        }
        return NO_DISCOUNT;
    }

    private static Integer applyHolidayDiscount(Map<Menu, Integer> orderItems, Integer reserveDate) {
        if (HolidayDiscount.isWithinPeriod(reserveDate)) {
            return HolidayDiscount.calculate(orderItems);
        }
        return NO_DISCOUNT;
    }

    private static Integer applySpecialDiscount(Integer reserveDate) {
        if (SpecialDiscount.isWithinPeriod(reserveDate)) {
            return SpecialDiscount.AMOUNT;
        }
        return NO_DISCOUNT;
    }
}
