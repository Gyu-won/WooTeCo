package bridge.view.message;

public enum Result {
    MAP("[%s]"),
    GAME_STATUS("게임 성공 여부: %s");

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage(String data) {
        return String.format(template, data);
    }
}