package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayDiscountTest {

    @DisplayName("평일 할인이 적용되는 경우")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 10, 12, 14, 19, 20, 21, 25, 31})
    public void 평일_할인이_적용_되는_날짜_테스트(Integer reserveDate) {
        //when
        boolean isWithinPeriod = WeekDayDiscount.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isTrue();
    }

    @DisplayName("평일 할인이 적용되지 않는 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    public void 평일_할인이_적용_되지_않는_날짜_테스트(Integer reserveDate) {
        //when
        boolean isWithinPeriod = WeekDayDiscount.isWithinPeriod(reserveDate);

        //then
        assertThat(isWithinPeriod).isFalse();
    }

    @DisplayName("평일 이벤트 할인금액을 계산한다.")
    @ParameterizedTest
    @MethodSource("MenuAndDiscountAmountProvider")
    public void 평일_이벤트_할인금액을_계산한다(List<Menu> menus, Integer expectedDiscountAmount, Integer orderAmount) {
        //given
        Map<Menu, Integer> orderItems = new HashMap<>();
        menus.forEach(menu -> orderItems.put(menu, orderAmount));

        //when
        Integer discountAmount = WeekDayDiscount.calculate(orderItems);

        //then
        assertThat(discountAmount).isEqualTo(expectedDiscountAmount);
    }

    static Stream<Arguments> MenuAndDiscountAmountProvider() {
        return Stream.of(
                Arguments.arguments(List.of(Menu.MushroomSoup, Menu.Tapas), 0, 1),
                Arguments.arguments(List.of(Menu.TBoneSteak, Menu.ChocolateCake), 2023, 1),
                Arguments.arguments(List.of(Menu.ChocolateCake, Menu.IceCream), 4046, 1),
                Arguments.arguments(List.of(Menu.ChocolateCake), 4046, 2)
        );
    }


}
