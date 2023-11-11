package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventServiceTest {

    @DisplayName("증정 이벤트가 적용되는 경우 증정품 가격을 계산")
    @ParameterizedTest
    @ValueSource(ints = {120000, 150000})
    public void 증정이벤트에_적용되는_경우(Integer totalOrderAmount) {
        //when
        Integer giftPrice = EventService.applyGiftEvent(totalOrderAmount);

        //then
        assertThat(giftPrice).isEqualTo(25000);
    }

    @DisplayName("증정 이벤트가 적용되지 않는 경우 증점품 금액을 계산")
    @ParameterizedTest
    @ValueSource(ints = {119999, 10000})
    public void 증정이벤트에_적용되지_않는_경우(Integer totalOrderAmount) {
        //when
        Integer giftPrice = EventService.applyGiftEvent(totalOrderAmount);

        //then
        assertThat(giftPrice).isEqualTo(0);
    }
}
