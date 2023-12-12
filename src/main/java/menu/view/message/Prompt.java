package menu.view.message;

public enum Prompt {
    START("점심 메뉴 추천을 시작합니다.\n"),
    COACH_NAME_INPUT("코치의 이름을 입력해 주세요. (, 로 구분)");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}