package christmas.domain.service;

import christmas.domain.entity.Menu;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Order {

    public static void validate(String menusInput) {
        List<String> menuInputs = splitMenusInput(menusInput);
        for (String menuInput : menuInputs) {
            List<String> menuAndCount = splitMenuAndCount(menuInput);
            checkInputTypeValidation(menuAndCount);
        }
    }

    public static Integer calculateTotalPrice(Map<Menu, Integer> orderMenus) {
        return orderMenus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    private static List<String> splitMenusInput(String menusInput) {
        return Arrays.asList(menusInput.split(",", -1));
    }

    private static List<String> splitMenuAndCount(String menuInput) {
        return Arrays.asList(menuInput.split("-", -1));
    }

    private static void checkInputTypeValidation(List<String> menuAndCount) {
        if (menuAndCount.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
