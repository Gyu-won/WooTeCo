package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasDiscountTest {

    @DisplayName("크리스마스 디데이 할인 날짜에 포함되는 경우")
    @ParameterizedTest
    @ValueSource(ints = {23, 1, 25})
    public void 크리스마스_할인_기간에_포함되는_경우(Integer reserveDate) {
        //when
        boolean isWithinPeriod = ChristmasDiscount.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isTrue();
    }

    @DisplayName("크리스마스 디데이 할인 날짜에 포함되지 않는 경우")
    @ParameterizedTest
    @ValueSource(ints = {26, 31})
    public void 크리스마스_할인_기간에_포함되지_않는_경우(Integer reserveDate) {
        //when
        boolean isWithinPeriod = ChristmasDiscount.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isFalse();
    }
}
