package menu.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static List<Coach> coaches = new ArrayList<>();

    public static void create(List<String> parsedCoachNameInput) {
        parsedCoachNameInput.forEach(name -> {
            coaches.add(new Coach(name));
        });
    }
}
