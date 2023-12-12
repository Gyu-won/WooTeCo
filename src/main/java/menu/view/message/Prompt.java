package menu.view.message;

public enum Prompt {
    START("점심 메뉴 추천을 시작합니다.\n");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}