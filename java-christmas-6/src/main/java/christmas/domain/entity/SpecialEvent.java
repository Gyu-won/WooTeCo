package christmas.domain.entity;

public class SpecialEvent {
    private static final int CHRISTMAS = 25;
    private static final int DAY_OF_WEEK = 7;
    private static final int SUNDAY = 3;
    private static final int DISCOUNT_AMOUNT = 1000;
    private static final int NO_DISCOUNT = 0;

    public static int apply(Integer visitDate) {
        if (visitDate == CHRISTMAS || visitDate % DAY_OF_WEEK == SUNDAY) {
            return DISCOUNT_AMOUNT;
        }
        return NO_DISCOUNT;
    }
}
