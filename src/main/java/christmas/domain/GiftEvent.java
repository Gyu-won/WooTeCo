package christmas.domain;

public class GiftEvent {
    private static final Integer MINIMUM_ORDER_AMOUNT = 120000;

    public static boolean isWithinPeriod(Integer totalOrderAmount) {
        return totalOrderAmount >= MINIMUM_ORDER_AMOUNT;
    }
}
