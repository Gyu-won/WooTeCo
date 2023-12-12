package menu.controller;

import java.util.List;
import menu.domain.entity.Coach;
import menu.domain.entity.CoachRepository;
import menu.domain.validation.CoachNameValidator;
import menu.domain.validation.MenuValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendation {
    public static void start() {
        OutputView.printStartMessage();

        List<Coach> coaches = createCoach();

        coaches.forEach(MenuRecommendation::askDislikeMenu);
    }

    private static void askDislikeMenu(Coach coach) {
        MenuValidator.validate(InputView.inputDislikeMenu(coach));
    }

    private static List<Coach> createCoach() {
        try {
            List<String> coachNames = CoachNameValidator.validate(InputView.inputCoachName());
            return CoachRepository.create(coachNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
        }
    }
}
