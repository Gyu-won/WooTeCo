package menu.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private List<Menu> dislikeMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void dislike(List<Menu> menus) {
        dislikeMenus.addAll(menus);
    }
}
