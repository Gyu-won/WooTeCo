package christmas.domain.service.event;

import christmas.domain.entity.DayOfWeek;

public class SpecialDiscount {
    private static final Integer CHRISTMAS_DAY = 25;
    public static final Integer AMOUNT = 1000;

    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isSunday(reserveDate) || isChristmasDay(reserveDate);
    }

    private static boolean isChristmasDay(Integer reserveDate) {
        return reserveDate.equals(CHRISTMAS_DAY);
    }
}