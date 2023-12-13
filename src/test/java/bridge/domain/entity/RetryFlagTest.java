package bridge.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RetryFlagTest {
    @DisplayName("종료를 선택한경우 false 값을 리턴")
    @Test
    public void 종료를_선택한_경우() {
        //when
        RetryFlag retryFlag = new RetryFlag("Q");

        //then
        assertThat(retryFlag.isRetry()).isFalse();
    }

    @DisplayName("재시작을 선택한 경우 true 값을 리턴")
    @Test
    public void 재시작을_선택한_경우() {
        //when
        RetryFlag retryFlag = new RetryFlag("R");

        //then
        assertThat(retryFlag.isRetry()).isTrue();
    }
}
