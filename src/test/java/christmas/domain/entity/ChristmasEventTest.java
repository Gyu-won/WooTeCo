package christmas.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasEventTest {
    @DisplayName("크리스마스 이벤트를 적용하여 할인 금액을 리턴한다.")
    @Test
    public void 크리스마스_이벤트_적용() {
        //given
        int visitDate = 24;

        // when
        int discountAmount = ChristmasEvent.apply(visitDate);

        // then
        assertThat(discountAmount).isEqualTo(3300);
    }
}
