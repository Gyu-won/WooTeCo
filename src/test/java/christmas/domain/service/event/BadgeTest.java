package christmas.domain.service.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {

    @DisplayName("혜택금액이 5000원 미만이면 배지가 없다.")
    @Test
    public void 아무_배지도_못받는_경우() {
        //given
        Integer totalEventReward = 4999;

        //when
        String rank = Badge.calculate(totalEventReward);

        //then
        assertThat(rank).isEqualTo("없음");
    }

    @DisplayName("혜택금액이 5000원 이상 10000원 미만이면  없다.")
    @ParameterizedTest
    @ValueSource(ints = {5000, 9999})
    public void 별_배지를_부여받는_경우(Integer totalEventReward) {
        //when
        String rank = Badge.calculate(totalEventReward);

        //then
        assertThat(rank).isEqualTo("별");
    }
}
