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

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}