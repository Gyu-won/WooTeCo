package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GiftEventServiceTestService {

    @DisplayName("증정 이벤트에 해당하면 증정이벤트를 적용한다..")
    @ParameterizedTest
    @ValueSource(ints = {120000, 150000})
    public void 총_주문금액이_12만원_이상인_경우(Integer totalOrderAmount) {
        //when
        boolean isApplicable = GiftEventService.isApplicable(totalOrderAmount);

        //then
        assertThat(isApplicable).isTrue();
    }

    @DisplayName("증정 이벤트에 해당하지 않으면 증정이벤트를 적용하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {10000, 119999})
    public void 총_주문금액이_12만원_이하인_경우(Integer totalOrderAmount) {
        //when
        boolean isApplicable = GiftEventService.isApplicable(totalOrderAmount);

        //then
        assertThat(isApplicable).isFalse();
    }
}
