package bridge.view.message;

public enum Error {
    INVALID_MOVE_BLOCK("이동할 칸은 U 또는 D만 입력 가능합니다."),
    INVALID_BRIDGE_SIZE("다리 크기는 3이상 20 이하의 정수입니다.");

    private static final String CODE = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = CODE + message;
    }

    public String getMessage() {
        return message;
    }
}