package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.view.message.Prompt;

public class InputView {
    public String readBridgeSize() {
        System.out.println(Prompt.BRIDGE_SIZE.getMessage());
        return readLine();
    }

    public String readMoving() {
        System.out.println(Prompt.MOVE_BLOCK.getMessage());
        return readLine();
    }

    public String readGameCommand() {
        System.out.println(Prompt.RESTART.getMessage());
        return readLine();
    }
}