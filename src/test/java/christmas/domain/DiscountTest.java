package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    @DisplayName("할인 금액의 합계를 계산")
    @Test
    public void 총_할인_금액을_계산() {
        //when
        int discountAmount = Discount.calculate();

        //then
        assertThat(discountAmount).isEqualTo(0);
    }
}
