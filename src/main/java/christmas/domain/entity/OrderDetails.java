package christmas.domain.entity;

import christmas.domain.service.event.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrderDetails {
    private static final Integer EVENT_APPLICABLE_MINIMUM_PRICE = 10000;
    private static final Integer NUMBER_OF_EVENT = 5;
    private static final Integer NO_DISCOUNT = 0;

    private final Integer reserveDate;
    private final Integer totalPrice;
    private final Map<Menu, Integer> orderMenus;

    public OrderDetails(Integer reserveDate, Map<Menu, Integer> orderMenus) {
        this.reserveDate = reserveDate;
        this.orderMenus = orderMenus;
        this.totalPrice = this.calculateTotalPrice();
    }

    public EventReward calculateEventReward() {
        if (totalPrice < EVENT_APPLICABLE_MINIMUM_PRICE) {
            return EventReward.create(cannotApplyEvent());
        }
        return EventReward.create(applyEvent());
    }

    public Integer calculateDiscountedPrice(EventReward eventReward) {
        return totalPrice - eventReward.calculateDiscountAmount();
    }

    private Integer calculateTotalPrice() {
        return this.orderMenus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    private List<Integer> cannotApplyEvent() {
        return Collections.nCopies(NUMBER_OF_EVENT, NO_DISCOUNT);
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

    public Integer getReserveDate() {
        return reserveDate;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public Map<Menu, Integer> getOrderMenus() {
        return orderMenus;
    }
}
