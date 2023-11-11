package christmas.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.entity.Menu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrderTest {

    @DisplayName("주문 메뉴의 금액 합계를 계산한다.")
    @ParameterizedTest
    @MethodSource("MenuAndPriceProvider")
    public void 주문한_메뉴의_금액합계를_계산(List<Menu> menus, Integer count, Integer expectedPrice) {
        //given
        Map<Menu, Integer> orderMenus = new HashMap<>();
        menus.forEach(menu -> orderMenus.put(menu, count));

        //when
        Integer totalPrice = Order.calculateTotalPrice(orderMenus);

        //then
        assertThat(totalPrice).isEqualTo(expectedPrice);
    }

    static Stream<Arguments> MenuAndPriceProvider() {
        return Stream.of(
                Arguments.arguments(List.of(Menu.TBoneSteak, Menu.BarbecueRibs, Menu.ZeroCoke), 1, 102000),
                Arguments.arguments(List.of(Menu.Tapas, Menu.RedWine), 2, 132000)
        );
    }
}
