package christmas.view.message;

public enum DynamicMessage {
    PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("%s %d개"),
    TOTAL_PRICE("%,d원"),
    DISCOUNT_AMOUNT("-%,d원");

    private final String template;

    DynamicMessage(String template) {
        this.template = template;
    }

    public String getMessage(Integer data) {
        return String.format(template, data);
    }

    public String getMessage(String stringData, Integer integerData) {
        return String.format(template, stringData, integerData);
    }
}
