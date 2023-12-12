package vendingmachine.view.message;

public enum Prompt {
    MachineMoney("자판기가 보유하고 있는 금액을 입력해 주세요.");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}