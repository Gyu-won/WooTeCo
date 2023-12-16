package oncall.view.message;

public enum Result {
    ;

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage() {
        return template;
    }
}