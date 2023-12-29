package bridge.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BridgeMakerTest {
    @DisplayName("입력된 크기만큼 다리를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 19})
    public void 다리_만들기(int size) {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        //when
        List<String> bridge = bridgeMaker.makeBridge(size);

        //then
        assertThat(bridge.size()).isEqualTo(size);
    }
}
