package vendingmachine.domain.entity;

public class Money {
    private Integer amount;

    public Money(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void minus(Integer price) {
        amount -= price;
    }

    public boolean isBiggerOrEqual(int minimumPrice) {
        return amount >= minimumPrice;
    }
}
