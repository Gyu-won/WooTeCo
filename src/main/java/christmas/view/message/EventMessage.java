package christmas.view.message;

import java.util.List;

public enum EventMessage {
    CHRISTMAS(0, "크리스마스 디데이 할인: -%,d원\n"),
    WEEKDAY(1, "평일 할인: -%,d원\n"),
    HOLIDAY(2, "주말 할인: -%,d원\n"),
    SPECIAL(3, "특별 할인: -%,d원\n"),
    GIFT(4, "증정 이벤트: -%,d원\n");

    private static final Integer NO_DISCOUNT = 0;
    private final int index;
    private final String template;

    EventMessage(int index, String template) {
        this.index = index;
        this.template = template;
    }

    public int getIndex() {
        return index;
    }

    public String getTemplate(Integer discountAmount) {
        return String.format(template, discountAmount);
    }

    public static String calculateAllBenefits(List<Integer> eventRewards) {
        StringBuilder allBenefits = new StringBuilder();
        for (EventMessage eventMessage : EventMessage.values()) {
            appendEventMessage(allBenefits, eventMessage, eventRewards);
        }
        return allBenefits.toString();
    }

    private static void appendEventMessage(StringBuilder allBenefits, EventMessage eventMessage,
                                           List<Integer> eventRewards) {
        Integer eventDiscountAmount = eventRewards.get(eventMessage.getIndex());
        if (!eventDiscountAmount.equals(NO_DISCOUNT)) {
            allBenefits.append(eventMessage.getTemplate(eventDiscountAmount));
        }
    }
}
