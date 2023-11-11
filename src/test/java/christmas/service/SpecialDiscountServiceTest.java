package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpecialDiscountServiceTest {

    @DisplayName("특별 이벤트 할인이 적용되는 경우")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    public void 특별_이벤트_할인이_적용되는_날짜_테스트(Integer reserveDate) {
        //when
        boolean isWithinPeriod = SpecialDiscountService.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isTrue();
    }

    @DisplayName("특별 이벤트 할인이 적용되지 않는 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 15, 23, 26, 30})
    public void 특별_이벤트_할인이_적용되지_않는_날짜_테스트(Integer reserveDate) {
        //when
        boolean isWithinPeriod = SpecialDiscountService.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isFalse();
    }
}
