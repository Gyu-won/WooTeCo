package menu.controller;

import java.util.List;
import menu.domain.RandomGenerator;
import menu.domain.entity.Category;
import menu.domain.entity.Coach;
import menu.domain.entity.CoachRepository;
import menu.domain.entity.Menu;
import menu.domain.entity.Weekday;
import menu.domain.validation.CoachNameValidator;
import menu.domain.validation.MenuValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendation {
    public static void start() {
        OutputView.printStartMessage();

        List<Coach> coaches = createCoach();

        coaches.forEach(MenuRecommendation::askDislikeMenu);

        for (Weekday weekday : Weekday.values()) {
            Category category = Category.validate(RandomGenerator.selectCategory());
            List<Menu> menus = Menu.findAllByCategory(category);
            CoachRepository.recommendMenu(menus);
        }
    }

    private static void askDislikeMenu(Coach coach) {
        try {
            List<Menu> menus = MenuValidator.validate(InputView.inputDislikeMenu(coach));
            coach.dislike(menus);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            askDislikeMenu(coach);
        }
    }

    private static List<Coach> createCoach() {
        try {
            List<String> coachNames = CoachNameValidator.validate(InputView.inputCoachName());
            return CoachRepository.create(coachNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return createCoach();
        }
    }
}
