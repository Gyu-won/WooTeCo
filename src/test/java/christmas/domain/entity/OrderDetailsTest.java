package christmas.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderDetailsTest {

    private Map<Menu, Integer> orderMenus;

    @BeforeEach
    public void setUp() {
        orderMenus = new HashMap<>();
    }

    @DisplayName("총 이벤트 할인 금액을 계산한다.")
    @Test
    public void 모든_이벤트_적용_후_할인금액을_계산() {
        //given
        orderMenus.put(Menu.TBoneSteak, 1);
        orderMenus.put(Menu.BarbecueRibs, 1);
        orderMenus.put(Menu.ChocolateCake, 2);
        orderMenus.put(Menu.ZeroCoke, 1);
        OrderDetails orderDetails = new OrderDetails(3, orderMenus);

        //when
        EventReward eventReward = orderDetails.calculateEventReward();

        //then
        assertThat(eventReward.sumEventRewards()).isEqualTo(31246);
    }

    @DisplayName("총 주문 금액이 10000원 미만인 경우에는 이벤트를 적용하지 않는다.")
    @Test
    public void 모든_이벤트를_적용하지_않는_경우() {
        //given
        orderMenus.put(Menu.Tapas, 1);
        orderMenus.put(Menu.ZeroCoke, 1);
        OrderDetails orderDetails = new OrderDetails(25, orderMenus);

        //when
        EventReward eventReward = orderDetails.calculateEventReward();

        //then
        assertThat(eventReward.sumEventRewards()).isEqualTo(0);
    }
}
