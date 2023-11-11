package christmas.domain.entity;

import christmas.domain.service.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDetails {
    private final Integer reserveDate;
    private final Integer totalPrice;
    private final Map<Menu, Integer> orderMenus;

    public OrderDetails(Integer reserveDate, Integer totalPrice, Map<Menu, Integer> orderMenus) {
        this.reserveDate = reserveDate;
        this.totalPrice = totalPrice;
        this.orderMenus = orderMenus;
    }

    public EventReward calculateEventReward() {
        List<Integer> eventRewards = new ArrayList<>();
        eventRewards.add(Event.applyChristmasDiscount(reserveDate));
        eventRewards.add(Event.applyWeekdayDiscount(reserveDate, orderMenus));
        eventRewards.add(Event.applyHolidayDiscount(reserveDate, orderMenus));
        eventRewards.add(Event.applySpecialDiscount(reserveDate));
        eventRewards.add(Event.applyGiftEvent(totalPrice));
        return EventReward.create(eventRewards);
    }
}
