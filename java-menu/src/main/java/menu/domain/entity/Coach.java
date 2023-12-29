package menu.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {

    private final String name;
    private List<Menu> dislikeMenus = new ArrayList<>();
    private List<Menu> ateMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void dislike(List<Menu> menus) {
        dislikeMenus.addAll(menus);
    }

    public List<String> getDislikeMenus() {
        return dislikeMenus.stream().map(Menu::name)
                .collect(Collectors.toList());
    }

    public List<String> getAteMenus() {
        return ateMenus.stream().map(Menu::name)
                .collect(Collectors.toList());
    }

    public void ate(Menu menu) {
        ateMenus.add(menu);
    }
}
