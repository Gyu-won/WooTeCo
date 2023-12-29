package vendingmachine.view.message;

public enum Error {
    MONEY_INPUT("올바르지 않은 금액 입력입니다."),
    MENU_INPUT("올바르지 않은 메뉴 입력입니다."),
    ORDER("올바르지 않은 주문 입력입니다."),
    PURCHASE("해당 상품은 구매하실 수 없습니다."),
    COIN("올바르지 않은 코인 입니다."),
    NO_PURCHASABLE_MENU("구매가능한 Menu가 없습니다.");

    private static final String CODE = "\n[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = CODE + message;
    }

    public String getMessage() {
        return message;
    }
}