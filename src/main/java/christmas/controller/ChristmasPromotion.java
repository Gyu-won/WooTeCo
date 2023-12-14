package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasPromotion {
    public static void start() {
        OutputView.printStartMessage();

        InputView.inputVisitDate();
    }
}
