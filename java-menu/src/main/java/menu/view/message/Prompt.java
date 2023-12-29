package menu.view.message;

public enum Prompt {
    START("점심 메뉴 추천을 시작합니다.\n"),
    COACH_NAME_INPUT("코치의 이름을 입력해 주세요. (, 로 구분)"),
    DISLIKE_MENU_INPUT("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
    RESULT("\n메뉴 추천 결과입니다."),
    END("\n추천을 완료했습니다.");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}