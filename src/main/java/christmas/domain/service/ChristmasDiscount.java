package christmas.domain.service;

public class ChristmasDiscount {
    private static final Integer EVENT_START_DATE = 1;
    private static final Integer EVENT_END_DATE = 25;
    private static final Integer BASIC_DISCOUNT = 1000;
    private static final Integer ADDITIONAL_DAILY_DISCOUNT = 100;

    public static boolean isWithinPeriod(Integer reserveDate) {
        return reserveDate <= EVENT_END_DATE;
    }

    public static Integer calculate(Integer reserveDate) {
        return BASIC_DISCOUNT + calculateDaysSinceEventStart(reserveDate) * ADDITIONAL_DAILY_DISCOUNT;
    }

    private static Integer calculateDaysSinceEventStart(Integer reserveDate) {
        return reserveDate - EVENT_START_DATE;
    }
}
