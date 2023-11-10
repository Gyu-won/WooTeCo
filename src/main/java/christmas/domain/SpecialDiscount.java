package christmas.domain;

public class SpecialDiscount {
    private static final Integer CHRISTMAS_DAY = 25;
    private static final Integer SPECIAL_DISCOUNT_AMOUNT = 1000;

    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isSunday(reserveDate) || isChristmasDay(reserveDate);
    }

    private static boolean isChristmasDay(Integer reserveDate) {
        return reserveDate.equals(CHRISTMAS_DAY);
    }
}
