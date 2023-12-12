package menu.controller;

import menu.domain.validation.CoachNameValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendation {
    public static void start() {
        OutputView.printStartMessage();

        CoachNameValidator.validate(InputView.inputCoachName());
    }
}
