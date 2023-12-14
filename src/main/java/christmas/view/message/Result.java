package christmas.view.message;

public enum Result {
    ORDER("%s %d개\n"),
    PRICE("%,d원\n"),
    NOTHING("없음"),
    GIFT_MENU("샴페인 1개"),
    EVENT("%s: -%,d원\n"),
    DISCOUNT_PRICE("%,d원\n");

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage() {
        return template;
    }
}
