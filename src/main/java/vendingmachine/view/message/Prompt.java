package vendingmachine.view.message;

public enum Prompt {
    MACHINE_MONEY_INPUT("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_COIN("\n자판기가 보유한 동전"),
    MENU_INPUT("\n상품명과 가격, 수량을 입력해 주세요."),
    INSERT_MONEY_INPUT("\n투입 금액을 입력해 주세요."),
    PURCHASE_INPUT("구매할 상품명을 입력해 주세요.");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}