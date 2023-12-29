package christmas.view.message;

public enum OrderMessage {
    ORDER_MENU("%s %d개"),
    TOTAL_PRICE("%,d원"),
    DISCOUNT_AMOUNT("-%,d원");

    private final String template;

    OrderMessage(String template) {
        this.template = template;
    }

    public String getMessage(Integer data) {
        return String.format(template, data);
    }

    public String getMessage(String stringData, Integer integerData) {
        return String.format(template, stringData, integerData);
    }
}