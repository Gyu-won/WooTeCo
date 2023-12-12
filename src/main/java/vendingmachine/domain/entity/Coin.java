package vendingmachine.domain.entity;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    //접근제어자 변경 불가능
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin findByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.amount == amount) {
                return coin;
            }
        }
        throw new IllegalArgumentException("올바르지 않은 코인 입니다.");
    }

    public int getAmount() {
        return amount;
    }
}
