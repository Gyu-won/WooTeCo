package bridge.view.message;

public enum Prompt {
    MOVE_BLOCK("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    BRIDGE_SIZE("\n다리의 길이를 입력해주세요."),
    RESTART("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("\n최종 게임 결과");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}