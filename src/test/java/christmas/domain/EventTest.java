package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventTest {

    @DisplayName("증정 이벤트가 적용되는 경우 증정품 가격을 계산")
    @ParameterizedTest
    @ValueSource(ints = {120000, 150000})
    public void 증정이벤트에_적용되는_경우(Integer totalOrderAmount) {
        //when
        Integer giftPrice = Event.applyGiftEvent(totalOrderAmount);

        //then
        assertThat(giftPrice).isEqualTo(25000);
    }

    @DisplayName("증정 이벤트가 적용되지 않는 경우 증점품 금액을 계산")
    @ParameterizedTest
    @ValueSource(ints = {119999, 10000})
    public void 증정이벤트에_적용되지_않는_경우(Integer totalOrderAmount) {
        //when
        Integer giftPrice = Event.applyGiftEvent(totalOrderAmount);

        //then
        assertThat(giftPrice).isEqualTo(0);
    }

    @DisplayName("할인 금액의 합계를 계산")
    @Test
    public void 총_할인금액_합계가_0인경우() {
        //given
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.Tapas, 1);
        orderItems.put(Menu.ZeroCoke, 1);

        Integer reserveDate = 26;

        //when
        Integer discountAmount = Event.applyDiscountEvent(orderItems, reserveDate);

        //then
        assertThat(discountAmount).isEqualTo(0);
    }

    @DisplayName("할인 금액의 합계를 계산")
    @Test
    public void 총_할인금액이_0이_아닌_경우() {
        //given
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.TBoneSteak, 1);
        orderItems.put(Menu.BarbecueRibs, 1);
        orderItems.put(Menu.ChocolateCake, 2);
        orderItems.put(Menu.ZeroCoke, 1);

        Integer reserveDate = 3;

        //when
        Integer discountAmount = Event.applyDiscountEvent(orderItems, reserveDate);

        //then
        assertThat(discountAmount).isEqualTo(6246);
    }
}
