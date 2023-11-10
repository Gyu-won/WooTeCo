package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayDiscountTest {

    @DisplayName("평일 할인이 적용되는 경우")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 10, 12, 14, 19, 20, 21, 25, 31})
    public void 평일_할인이_적용_되는_날짜_테스트(Integer reserveDate) {
        //when
        boolean isWithinPeriod = WeekDayDiscount.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isTrue();
    }

    @DisplayName("평일 할인이 적용되지 않는 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    public void 평일_할인이_적용_되지_않는_날짜_테스트(Integer reserveDate) {
        //when
        boolean isWithinPeriod = WeekDayDiscount.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isFalse();
    }
}
