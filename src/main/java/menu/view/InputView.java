package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import menu.view.message.Prompt;

public class InputView {
    public static String inputCoachName() {
        System.out.println(Prompt.COACH_NAME_INPUT.getMessage());
        return readLine();
    }
}