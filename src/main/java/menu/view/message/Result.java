package menu.view.message;

import java.util.List;

public enum Result {
    WEEKDAY("[ 구분 | %s | %s | %s | %s | %s ]\n"),
    CATEGORY("[ 카테고리 | %s | %s | %s | %s | %s ]"),
    COACH_FOOD("[ %s | %s | %s | %s | %s | %s ]");

    private final String template;

    Result(String template) {
        this.template = template;
    }

    public String getMessage(List<String> data) {
        return String.format(template, data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));
    }

    public String getMessage(String name, List<String> ateFoods) {
        return String.format(template, name, ateFoods.get(0), ateFoods.get(1), ateFoods.get(2), ateFoods.get(3),
                ateFoods.get(4));
    }
}
