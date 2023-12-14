package christmas.view.message;

public enum Result {
    ORDER("%s %d");

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage(String menuName, Integer count) {
        return String.format(template, menuName, count);
    }
}
