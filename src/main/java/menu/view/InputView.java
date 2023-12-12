package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.view.message.Prompt;

public class InputView {
    public static String input메서드명() {
        System.out.println(Prompt.메시지명.getMessage());
        return readLine();
    }
}