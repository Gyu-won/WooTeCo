package bridge.view.message;

public enum Prompt {
    MOVE_BLOCK("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}