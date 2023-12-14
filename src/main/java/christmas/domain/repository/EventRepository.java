package christmas.domain.repository;

import christmas.domain.entity.ChristmasEvent;
import christmas.domain.entity.DayEvent;
import christmas.domain.entity.Order;
import christmas.domain.entity.SpecialEvent;
import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private static final Map<String, Integer> discountDetails = new HashMap<>();
    private static final Integer GIFT_EVENT_PRICE_CONDITION = 120000;
    private static final Integer DISCOUNT_EVENT_PRICE_CONDITION = 10000;
    private static final Integer GIFT_EVENT_AMOUNT = 25000;
    private static final Integer NO_DISCOUNT = 0;
    private static final Integer SYMBOL = -1;
    private static final String GIFT_EVENT = "증정 이벤트";
    private static final String SPECIAL_DISCOUNT = "특별 할인";
    private static final String HOLIDAY_DISCOUNT = "주말 할인";
    private static final String WEEKDAY_DISCOUNT = "평일 할인";
    private static final String CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인";


    public static Map<String, Integer> applyGiftEvent(Order order) {
        if (order.calculatePrice() >= GIFT_EVENT_PRICE_CONDITION) {
            discountDetails.put(GIFT_EVENT, GIFT_EVENT_AMOUNT);
        }
        return discountDetails;
    }

    public static Map<String, Integer> applyDiscountEvent(Order order, Integer visitDate) {
        if (order.calculatePrice() >= DISCOUNT_EVENT_PRICE_CONDITION) {
            applyChristmasEvent(visitDate);
            applyDayEvent(order, visitDate);
            applySpecialEvent(visitDate);
        }
        return discountDetails;
    }

    private static void applySpecialEvent(Integer visitDate) {
        int discountPrice = SpecialEvent.apply(visitDate);
        if (discountPrice != NO_DISCOUNT) {
            discountDetails.put(SPECIAL_DISCOUNT, discountPrice);
        }
    }

    private static void applyDayEvent(Order order, Integer visitDate) {
        if (DayEvent.applicableHolidayEvent(visitDate)) {
            discountDetails.put(HOLIDAY_DISCOUNT, DayEvent.applyHoliday(order));
            return;
        }
        discountDetails.put(WEEKDAY_DISCOUNT, DayEvent.applyWeekday(order));

    }

    private static void applyChristmasEvent(Integer visitDate) {
        int discountPrice = ChristmasEvent.apply(visitDate);
        if (discountPrice != NO_DISCOUNT) {
            discountDetails.put(CHRISTMAS_DISCOUNT, discountPrice);
        }
    }

    public static Integer calculateTotalDiscountPrice() {
        return SYMBOL * discountDetails.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Integer calculateFinalPrice(Order order) {
        int discountPrice = calculateTotalDiscountPrice();
        if (discountDetails.containsKey(GIFT_EVENT)) {
            discountPrice += GIFT_EVENT_AMOUNT;
        }
        return order.calculatePrice() + discountPrice;
    }
}
