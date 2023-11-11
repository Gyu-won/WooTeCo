package christmas.domain.entity;

public class TotalEventReward {
    private final Integer christmasDiscount;
    private final Integer weekdayDiscount;
    private final Integer holidayDiscount;
    private final Integer specialDiscount;
    private final Integer giftEvent;

    private TotalEventReward(Integer christmasDiscount, Integer weekdayDiscount, Integer holidayDiscount,
                             Integer specialDiscount, Integer giftEvent) {
        this.christmasDiscount = christmasDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.holidayDiscount = holidayDiscount;
        this.specialDiscount = specialDiscount;
        this.giftEvent = giftEvent;
    }

    public static TotalEventReward create(Integer christmasDiscount, Integer weekdayDiscount, Integer holidayDiscount,
                                          Integer specialDiscount, Integer giftEvent) {
        return new TotalEventReward(christmasDiscount, weekdayDiscount, holidayDiscount, specialDiscount, giftEvent);
    }

    public Integer sumEventDiscounts() {
        return null;
    }
}
