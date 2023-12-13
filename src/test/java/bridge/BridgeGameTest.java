package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.entity.BridgeGame;
import bridge.domain.entity.BridgeGameResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    public void setUp() {
        bridgeGame = new BridgeGame(List.of("U"));
    }

    @DisplayName("다리를 건너가는 경우 게임 진행")
    @Test
    public void 다리를_건널_수_있는경우() {
        //when
        BridgeGameResult bridgeGameResult = bridgeGame.move("U");

        //then
        assertThat(bridgeGameResult.isGameOver()).isFalse();
    }

    @DisplayName("다리를 건너가지 못하는 경우 게임 종료")
    @Test
    public void 다리를_건널_수_없는경우() {
        //when
        BridgeGameResult bridgeGameResult = bridgeGame.move("D");

        //then
        assertThat(bridgeGameResult.isGameOver()).isTrue();
    }
}
