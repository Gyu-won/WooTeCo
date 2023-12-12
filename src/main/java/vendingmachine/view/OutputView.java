package vendingmachine.view;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.entity.Coin;
import vendingmachine.domain.entity.Money;
import vendingmachine.view.message.Prompt;

public class OutputView {
    private static final int MINIMUM_COIN_NUMBER = 0;
    private static final String COIN_PRINT_FORMAT = "%d원 - %d개\n";
    private static final String EXCHANGE_PRINT_FORMAT = "%d원 - %d개\n";


    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printCoin(Map<Coin, Integer> coins) {
        System.out.println(Prompt.MACHINE_COIN.getMessage());
        for (Coin coin : Coin.values()) {
            System.out.printf(COIN_PRINT_FORMAT, coin.getAmount(), coins.get(coin));
        }
    }

    public static void printLeftMoney(Money money) {
        System.out.printf("\n투입 금액: %d원", money.getAmount());
    }

    public static void printExchange(List<Integer> exchange) {
        System.out.println(Prompt.EXCHANGE.getMessage());
        for (Coin coin : Coin.values()) {
            int numberOfCoin = exchange.get(coin.getIndex());
            if (numberOfCoin > MINIMUM_COIN_NUMBER) {
                System.out.printf(EXCHANGE_PRINT_FORMAT, coin.getAmount(), numberOfCoin);
            }
        }
    }
}