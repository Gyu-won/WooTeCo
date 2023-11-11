package christmas.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @DisplayName("총 이벤트 할인 금액을 계산한다.")
    @Test
    public void 모든_이벤트_적용_후_할인금액을_계산() {
        //given
        Map<Menu, Integer> orderMenus = new HashMap<>();
        orderMenus.put(Menu.TBoneSteak, 1);
        orderMenus.put(Menu.BarbecueRibs, 1);
        orderMenus.put(Menu.ChocolateCake, 2);
        orderMenus.put(Menu.ZeroCoke, 1);

        Order order = new Order(orderMenus, 142000);

        //when
        EventReward eventReward = order.calculateEventReward();

        //then
        assertThat(eventReward.sumEventDiscounts()).isEqualTo(31246);
    }
}
