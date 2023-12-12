package menu.domain.entity;

import menu.view.message.Error;

public enum Menu {
    GYUDONG("규동", Category.JAPANESE);

    private final String name;
    private final Category category;

    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static boolean isContain(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(menuName)) {
                return true;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_MENU_NAME.getMessage());
    }

    public static Menu findByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_MENU_NAME.getMessage());
    }
}
