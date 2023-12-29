package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.entity.Menu;

public class RandomGenerator {
    public static Integer selectCategory() {
        return Randoms.pickNumberInRange(1, 5);
    }

    public static Menu recommendMenu(List<String> menus, List<String> dislikeMenus, List<String> ateMenus) {
        String menuName = selectMenu(menus);
        if (dislikeMenus.contains(menuName) || ateMenus.contains(menuName)) {
            return recommendMenu(menus, dislikeMenus, ateMenus);
        }
        return Menu.findByName(menuName);
    }

    private static String selectMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
