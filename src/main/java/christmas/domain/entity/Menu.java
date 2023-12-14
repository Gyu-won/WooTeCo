package christmas.domain.entity;

import java.util.Map;

public enum Menu {
    APPETIZER(Map.of("양송이수프", 6000,
            "타파스", 5500,
            "시저샐러드", 8000)),
    MAIN(Map.of("티본스테이크", 55000,
            "바비큐립", 54000,
            "해산물파스타", 35000,
            "크리스마스파스타", 25000)),
    DESSERT(Map.of("초코케이크", 15000,
            "아이스크림", 5000)),
    BEVERAGE(Map.of("제로콜라", 3000,
            "레드와인", 60000,
            "샴페인", 25000));

    private final Map<String, Integer> menu;

    Menu(Map<String, Integer> menu) {
        this.menu = menu;
    }

    public static boolean isContain(String menuName) {
        for (Menu menuType : Menu.values()) {
            if (menuType.menu.containsKey(menuName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBeverage(String menuName) {
        return Menu.BEVERAGE.menu.containsKey(menuName);
    }

    public static Integer findPriceByName(String name) {
        for (Menu menuType : Menu.values()) {
            Integer price = menuType.menu.get(name);
            if (price != null) {
                return price;
            }
        }
        return 0;
    }

    public static boolean isDessert(String name) {
        return Menu.DESSERT.menu.containsKey(name);
    }
}
