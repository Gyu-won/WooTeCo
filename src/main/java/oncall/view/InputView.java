package oncall.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import oncall.view.message.Prompt;

public class InputView {
    public static String readMonthAndWeekday() {
        System.out.printf(Prompt.INPUT_MONTH_AND_WEEKDAY.getMessage());
        return readLine();
    }

    public static String readWeekdayWorkers() {
        System.out.printf(Prompt.INPUT_WEEKDAY_WORKER.getMessage());
        return readLine();
    }
}