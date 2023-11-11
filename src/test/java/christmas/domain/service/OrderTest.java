package christmas.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.entity.Menu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {
    @DisplayName("주문 메뉴 입력의 형식이 올바르지 않으면 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2,레드와인=1", "해산물파스타-2,"})
    public void 주문메뉴_입력의_형식이_올바르지_않은_경우(String menusInput) {
        //when+then
        assertThatThrownBy(() -> Order.validate(menusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력한 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스티-2", "해산물파스타-2, 레드와인-1"})
    public void 메뉴판에_없는_메뉴를_입력한_경우(String menusInput) {
        //when+then
        assertThatThrownBy(() -> Order.validate(menusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 개수를 올바르게 입력하지 않으면 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-1,레드와인-0", "양송이수프-0.5", "티본스테이크-4"})
    public void 메뉴_개수를_올바르게_입력한_경우(String menusInput) {
        //when+then
        assertThatThrownBy(() -> Order.validate(menusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

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
                Arguments.arguments(List.of(Menu.TBoneSteak, Menu.BarbecueRibs, Menu.ZeroCoke), 1, 112000),
                Arguments.arguments(List.of(Menu.Tapas, Menu.RedWine), 2, 131000)
        );
    }
}
