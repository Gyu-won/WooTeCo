package christmas.domain;

import java.util.Map;

public class Event {

    public static Integer applyGiftEvent(Integer totalOrderAmount) {
        if (GiftEvent.isApplicable(totalOrderAmount)) {
            return Menu.calculateGiftPrice();
        }
        return 0;
    }

    public static Integer applyDiscountEvent(Map<Menu, Integer> orderItems, Integer reserveDate) {
        int totalDiscount = 0;
        return totalDiscount;
    }
}
