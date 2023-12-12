package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import menu.domain.entity.Coach;
import menu.view.message.Prompt;

public class InputView {
    public static String inputCoachName() {
        System.out.println(Prompt.COACH_NAME_INPUT.getMessage());
        return readLine();
    }

    public static String inputDislikeMenu(Coach coach) {
        System.out.printf(Prompt.DISLIKE_MENU_INPUT.getMessage(), coach.getName());
        return readLine();
    }
}