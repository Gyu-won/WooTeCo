package christmas.domain.service;

public class GiftEvent {
    private static final Integer MINIMUM_ORDER_AMOUNT = 120000;

    public static boolean isApplicable(Integer totalOrderAmount) {
        return totalOrderAmount >= MINIMUM_ORDER_AMOUNT;
    }
}
