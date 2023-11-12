package christmas.domain.service.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {

    @DisplayName("혜택금액이 5000원 미만이면 아무 등급도 아니다.")
    @Test
    public void 아무_등급이_아닌_경우() {
        //given
        Integer totalEventReward = 4999;

        //when
        String rank = Badge.calculate(totalEventReward);

        //then
        assertThat(rank).isEqualTo("없음");
    }
}
