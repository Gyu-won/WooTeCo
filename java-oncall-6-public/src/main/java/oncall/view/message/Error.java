package oncall.view.message;

public enum Error {
    INVALID_DATE("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    INVALID_WORKER("유효하지 않은 사원 이름 입력 값입니다. 다시 입력해 주세요.");

    private static final String CODE = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = CODE + message;
    }

    public String getMessage() {
        return message;
    }
}