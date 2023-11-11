package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventTest {

    @DisplayName("할인 금액의 합계를 계산")
    @Test
    public void 총_할인금액_합계가_0인경우() {
        //given
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.Tapas, 1);
        orderItems.put(Menu.ZeroCoke, 1);

        Integer reserveDate = 26;

        //when
        int discountAmount = Event.apply(orderItems, reserveDate);

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
        int discountAmount = Event.apply(orderItems, reserveDate);

        //then
        assertThat(discountAmount).isEqualTo(31246);
    }
}
