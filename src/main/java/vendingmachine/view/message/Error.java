package vendingmachine.view.message;

public enum Error {
    MONEY_INPUT("\n올바르지 않은 금액 입력입니다."),
    MENU_INPUT("\n올바르지 않은 메뉴 입력입니다.");

    private static final String CODE = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = CODE + message;
    }

    public String getMessage() {
        return message;
    }
}