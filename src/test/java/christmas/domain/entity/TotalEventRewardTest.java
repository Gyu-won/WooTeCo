package christmas.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalEventRewardTest {

    @DisplayName("총 할인 금액의 합을 계산한다.")
    @Test
    public void 총_할인금액을_계산() {
        //given
        Integer christmasDiscount = 1200;
        Integer weekdayDiscount = 4046;
        Integer holidayDiscount = 0;
        Integer specialDiscount = 1000;
        Integer giftEvent = 25000;

        TotalEventReward totalEventReward = TotalEventReward.create(christmasDiscount, weekdayDiscount, holidayDiscount,
                specialDiscount, giftEvent);

        //when
        Integer totalEventDiscounts = totalEventReward.sumEventDiscounts();

        //then
        assertThat(totalEventDiscounts).isEqualTo(31246);
    }
}
