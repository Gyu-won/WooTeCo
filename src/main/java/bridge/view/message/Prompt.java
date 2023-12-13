package bridge.view.message;

public enum Prompt {
    MOVE_BLOCK("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    BRIDGE_SIZE("다리의 길이를 입력해주세요.");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}