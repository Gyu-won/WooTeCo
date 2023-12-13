package bridge.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RetryFlagTest {
    @DisplayName("재시작이 아닌경우")
    @Test
    public void 재시작이_아닌경우() {
        //when
        RetryFlag retryFlag = new RetryFlag("Q");

        //then
        assertThat(retryFlag.isRetry()).isFalse();
    }
}
