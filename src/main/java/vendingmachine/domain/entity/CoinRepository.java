package vendingmachine.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.domain.service.RandomCoinGenerator;

public class CoinRepository {
    private static final Map<Coin, Integer> coins = new HashMap<>();

    static {
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
    }

    public static Map<Coin, Integer> generate(Integer money) {
        while (money > 0) {
            Coin coin = RandomCoinGenerator.generate(money);
            coins.put(coin, coins.get(coin) + 1);
            money -= coin.getAmount();
        }
        return coins;
    }

    public static List<Integer> calculateExchange(Money money) {
        // index 0이 500원
        List<Integer> exchanges = new ArrayList<>(Collections.nCopies(4, 0));
        while (isAvailableToReturn(money)) {

        }
        return exchanges;
    }

    private static boolean isAvailableToReturn(Money money) {
        return money.isBiggerOrEqual(calculateMinimumExchange());
    }

    private static int calculateMinimumExchange() {
        int minAmount = Integer.MAX_VALUE;
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            if (entry.getValue() > 0) {
                minAmount = entry.getKey().getAmount();
            }
        }
        return minAmount;
    }
}
