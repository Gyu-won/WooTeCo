package oncall.view.message;

public enum Result {
    DAY_WORKER("%d월 %d일 %s %s");

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage() {
        return template;
    }
}