package christmas.domain.entity;

import christmas.domain.service.Event;
import christmas.domain.service.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrderDetails {
    private final Integer reserveDate;
    private final Integer totalPrice;
    private final Map<Menu, Integer> orderMenus;

    public OrderDetails(Integer reserveDate, Map<Menu, Integer> orderMenus) {
        this.reserveDate = reserveDate;
        this.orderMenus = orderMenus;
        this.totalPrice = Order.calculateTotalPrice(orderMenus);
    }

    public EventReward calculateEventReward() {
        if (totalPrice < 10000) {
            return EventReward.create(cannotApplyEvent());
        }
        return EventReward.create(applyEvent());
    }

    private List<Integer> cannotApplyEvent() {
        return Collections.nCopies(5, 0);
    }

    private List<Integer> applyEvent() {
        List<Integer> eventRewards = new ArrayList<>();
        eventRewards.add(Event.applyChristmasDiscount(reserveDate));
        eventRewards.add(Event.applyWeekdayDiscount(reserveDate, orderMenus));
        eventRewards.add(Event.applyHolidayDiscount(reserveDate, orderMenus));
        eventRewards.add(Event.applySpecialDiscount(reserveDate));
        eventRewards.add(Event.applyGiftEvent(totalPrice));
        return eventRewards;
    }
}
