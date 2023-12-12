package vendingmachine.view.message;

public enum Error {
    MONEY("올바르지 않은 금액 입력입니다.");

    private static final String CODE = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = CODE + message;
    }

    public String getMessage() {
        return message;
    }
}