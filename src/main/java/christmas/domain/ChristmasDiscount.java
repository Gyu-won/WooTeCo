package christmas.domain;

public class ChristmasDiscount {
    private static final Integer EVENT_END_DATE = 25;

    public static boolean isWithinPeriod(Integer reserveDate) {
        return reserveDate <= EVENT_END_DATE;
    }

    public static Integer calculate(Integer reserveDate) {
        return 0;
    }
}
