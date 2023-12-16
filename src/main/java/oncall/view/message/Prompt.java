package oncall.view.message;

public enum Prompt {
    INPUT_MONTH_AND_WEEKDAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}