package vendingmachine.domain.entity;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.domain.service.RandomCoinGenerator;

public class CoinRepository {
    private static final Map<Integer, Integer> coins = new HashMap<>();

    static {
        coins.put(500, 0);
        coins.put(100, 0);
        coins.put(50, 0);
        coins.put(10, 0);
    }

    public static Map<Integer, Integer> generate(Integer money) {
        while (money > 0) {
            int coin = RandomCoinGenerator.generate(money);
            coins.put(coin, coins.get(coin) + 1);
            money -= coin;
        }
        return coins;
    }
}
