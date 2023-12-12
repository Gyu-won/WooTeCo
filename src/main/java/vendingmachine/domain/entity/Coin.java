package vendingmachine.domain.entity;

import vendingmachine.view.message.Error;

public enum Coin {
    COIN_500(0, 500),
    COIN_100(1, 100),
    COIN_50(2, 50),
    COIN_10(3, 10);

    //접근제어자 변경 불가능
    private final int index;
    private final int amount;

    Coin(final int index, final int amount) {
        this.index = index;
        this.amount = amount;
    }

    public static Coin findByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.amount == amount) {
                return coin;
            }
        }
        throw new IllegalArgumentException(Error.COIN.getMessage());
    }

    public int getAmount() {
        return amount;
    }

    public int getIndex() {
        return index;
    }
}
