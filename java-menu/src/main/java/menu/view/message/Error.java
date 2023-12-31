package menu.view.message;

public enum Error {
    NUMBER_OF_COACH("코치의 숫자는 2이상 5이하의 숫자여야 합니다."),
    NAME_LENGTH_OF_COACH("코치의 이름은 2자 이상, 4자 이하여야 합니다."),
    DUPLICATE_COACH_NAME("중복된 코치가 존재합니다."),
    NUMBER_OF_DISLIKE_MENU("못 먹는 메뉴가 너무 많습니다."),
    DUPLICATE_DISLIKE_MENU("중복된 메뉴가 입력되었습니다."),
    INVALID_MENU_NAME("메뉴에 존재하지 않는 메뉴이름이 입력되었습니다.");

    private static final String CODE = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = CODE + message;
    }

    public String getMessage() {
        return message;
    }
}