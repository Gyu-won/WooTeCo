package oncall.view.message;

public enum Prompt {
    ;

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}