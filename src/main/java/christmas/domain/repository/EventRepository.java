package christmas.domain.repository;

import christmas.domain.entity.ChristmasEvent;
import christmas.domain.entity.DayEvent;
import christmas.domain.entity.Order;
import christmas.domain.entity.SpecialEvent;
import christmas.domain.entity.VisitDate;
import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private static final Map<String, Integer> discountDetails = new HashMap<>();

    public static Map<String, Integer> applyGiftEvent(Order order) {
        if (order.calculatePrice() >= 120000) {
            discountDetails.put("증정 이벤트", 25000);
        }
        return discountDetails;
    }

    public static Map<String, Integer> applyDiscountEvent(Order order, VisitDate visitDate) {
        if (order.calculatePrice() >= 10000) {
            applyChristmasEvent(order, visitDate);
            applyDayEvent(order, visitDate);
            applySpecialEvent(visitDate);
        }
        return discountDetails;
    }

    private static void applySpecialEvent(VisitDate visitDate) {
        int discountPrice = SpecialEvent.apply(visitDate);
        if (discountPrice != 0) {
            discountDetails.put("특별 할인", discountPrice);
        }
    }

    private static void applyDayEvent(Order order, VisitDate visitDate) {
        if (DayEvent.applicableHolidayEvent(visitDate)) {
            discountDetails.put("주말 할인", DayEvent.applyHoliday(order));
            return;
        }
        discountDetails.put("평일 할인", DayEvent.applyWeekday(order));

    }

    private static void applyChristmasEvent(Order order, VisitDate visitDate) {
        int discountPrice = ChristmasEvent.apply(order, visitDate);
        if (discountPrice != 0) {
            discountDetails.put("크리스마스 디데이 할인", discountPrice);
        }
    }
}
