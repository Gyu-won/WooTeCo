package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.view.message.Prompt;

public class InputView {
    public static String readVisitDate() {
        System.out.println(Prompt.VISIT_DATE.getMessage());
        return readLine();
    }

    public static String readOrder() {
        System.out.println(Prompt.ORDER.getMessage());
        return readLine();
    }
}