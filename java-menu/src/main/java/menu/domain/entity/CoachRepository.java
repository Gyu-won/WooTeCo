package menu.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.RandomGenerator;

public class CoachRepository {

    private static List<Coach> coaches = new ArrayList<>();

    public static List<Coach> create(List<String> parsedCoachNameInput) {
        parsedCoachNameInput.forEach(name -> {
            coaches.add(new Coach(name));
        });
        return coaches;
    }

    public static void recommendMenu(List<Menu> menus) {
        List<String> menuNames = menus.stream().map(Menu::name)
                .collect(Collectors.toList());
        for (Coach coach : coaches) {
            Menu menu = RandomGenerator.recommendMenu(menuNames, coach.getDislikeMenus(), coach.getAteMenus());
            coach.ate(menu);
        }
    }
}
