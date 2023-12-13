package bridge.view.message;

public enum Error {
    INVALID_MOVE_VLOCK("이동할 칸은 U 또는 D만 입력 가능합니다.");

    private static final String CODE = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = CODE + message;
    }

    public String getMessage() {
        return message;
    }
}