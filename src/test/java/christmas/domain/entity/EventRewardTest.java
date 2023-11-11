package christmas.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventRewardTest {

    @DisplayName("총 할인 금액의 합을 계산한다.")
    @Test
    public void 총_할인금액을_계산() {
        //given
        List<Integer> totalEventRewards = List.of(1200, 4046, 0, 1000, 25000);
        EventReward eventReward = EventReward.create(totalEventRewards);

        //when
        Integer totalEventDiscounts = eventReward.sumEventDiscounts();

        //then
        assertThat(totalEventDiscounts).isEqualTo(31246);
    }
}
