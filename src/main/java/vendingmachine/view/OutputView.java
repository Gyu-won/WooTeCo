package vendingmachine.view;

import java.util.Map;
import vendingmachine.view.message.Prompt;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printCoin(Map<Integer, Integer> coins) {
        System.out.println(Prompt.MACHINE_COIN.getMessage());
        System.out.printf("%d원 - %d개\n", 500, coins.get(500));
        System.out.printf("%d원 - %d개\n", 100, coins.get(100));
        System.out.printf("%d원 - %d개\n", 50, coins.get(50));
        System.out.printf("%d원 - %d개\n", 10, coins.get(10));
    }
}