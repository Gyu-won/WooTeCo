package menu.view;

import java.util.List;
import menu.domain.entity.Category;
import menu.domain.entity.Coach;
import menu.domain.entity.Weekday;
import menu.view.message.Prompt;
import menu.view.message.Result;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printStartMessage() {
        System.out.println(Prompt.START.getMessage());
    }

    public static void printRecommendResult(List<Coach> coaches) {
        System.out.println(Prompt.RESULT.getMessage());
        System.out.println(Result.WEEKDAY.getMessage(Weekday.getAllName()));
        System.out.println(Result.CATEGORY.getMessage(Category.getAllName()));
        for (Coach coach : coaches) {
            System.out.println(Result.COACH_FOOD.getMessage(coach.getName(), coach.getAteMenus()));
        }
    }

    public static void printEndMessage() {
        System.out.println(Prompt.END.getMessage());
    }
}