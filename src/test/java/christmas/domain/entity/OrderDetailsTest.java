package christmas.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("주문 메뉴의 금액 합계를 계산한다.")
    @ParameterizedTest
    @MethodSource("MenuAndPriceProvider")
    public void 주문한_메뉴의_금액합계를_계산(List<Menu> menus, Integer count, Integer expectedPrice) {
        //given
        menus.forEach(menu -> orderMenus.put(menu, count));

        //when
        OrderDetails orderDetails = new OrderDetails(25, orderMenus);

        //then
        assertThat(orderDetails.getTotalPrice()).isEqualTo(expectedPrice);
    }

    static Stream<Arguments> MenuAndPriceProvider() {
        return Stream.of(
                Arguments.arguments(List.of(Menu.TBoneSteak, Menu.BarbecueRibs, Menu.ZeroCoke), 1, 112000),
                Arguments.arguments(List.of(Menu.Tapas, Menu.RedWine), 2, 131000)
        );
    }

    @DisplayName("할인 전 총 주문 금액에서 할인금액을 뺴서 예상결제금액을 계산한다.")
    @Test
    public void 예상결제금액을_계산() {
        //given
        EventReward eventReward = EventReward.create(List.of(1200, 4046, 0, 1000, 25000));
        orderMenus.put(Menu.TBoneSteak, 1);
        orderMenus.put(Menu.BarbecueRibs, 1);
        orderMenus.put(Menu.ChocolateCake, 2);
        orderMenus.put(Menu.ZeroCoke, 1);
        OrderDetails orderDetails = new OrderDetails(3, orderMenus);

        //when
        Integer discountedPrice = orderDetails.calculateDiscountedPrice(eventReward);

        //then
        assertThat(discountedPrice).isEqualTo(135754);
    }
}
