package christmas.service;

import christmas.domain.Menu;
import java.util.Map;

public class EventService {
    private static final Integer NO_DISCOUNT = 0;

    public static Integer applyGiftEvent(Integer totalOrderAmount) {
        if (GiftEventService.isApplicable(totalOrderAmount)) {
            return Menu.calculateGiftPrice();
        }
        return NO_DISCOUNT;
    }

    public static Integer applyChristmasDiscount(Integer reserveDate) {
        if (ChristmasDiscountService.isWithinPeriod(reserveDate)) {
            return ChristmasDiscountService.calculate(reserveDate);
        }
        return NO_DISCOUNT;
    }

    public static Integer applyWeekdayDiscount(Map<Menu, Integer> orderItems, Integer reserveDate) {
        if (WeekdayDiscountService.isWithinPeriod(reserveDate)) {
            return WeekdayDiscountService.calculate(orderItems);
        }
        return NO_DISCOUNT;
    }

    public static Integer applyHolidayDiscount(Map<Menu, Integer> orderItems, Integer reserveDate) {
        if (HolidayDiscountService.isWithinPeriod(reserveDate)) {
            return HolidayDiscountService.calculate(orderItems);
        }
        return NO_DISCOUNT;
    }

    public static Integer applySpecialDiscount(Integer reserveDate) {
        if (SpecialDiscountService.isWithinPeriod(reserveDate)) {
            return SpecialDiscountService.AMOUNT;
        }
        return NO_DISCOUNT;
    }
}
