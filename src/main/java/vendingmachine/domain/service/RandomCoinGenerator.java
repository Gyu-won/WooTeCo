package vendingmachine.domain.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.entity.Coin;

public class RandomCoinGenerator {

    public static Integer generate(Integer money) {
        List<Integer> coinAmounts = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() <= money) {
                coinAmounts.add(coin.getAmount());
            }
        }
        return pickNumberInList(coinAmounts);
    }
}
