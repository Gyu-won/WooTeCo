package christmas.view.message;

public enum Result {
    ORDER("%s %d\n"),
    PRICE("%,d원\n"),
    NOTHING("없음"),
    GIFT_MENU("샴페인 1개");

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage() {
        return template;
    }
}
