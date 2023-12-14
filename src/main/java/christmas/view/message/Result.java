package christmas.view.message;

public enum Result {
    ORDER("%s %d\n"),
    PRICE("%,d원\n");

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage() {
        return template;
    }
}
