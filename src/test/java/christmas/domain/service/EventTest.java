package christmas.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.entity.Menu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EventTest {

    @DisplayName("증정 이벤트가 적용되는 경우 증정품 가격을 계산")
    @ParameterizedTest
    @CsvSource({"120000, 25000", "150000, 25000", "119999, 0", "10000, 0"})
    public void 증정품_이벤트_적용_후_혜택내역(Integer totalOrderAmount, Integer expectedGiftPrice) {
        //when
        Integer giftPrice = Event.applyGiftEvent(totalOrderAmount);

        //then
        assertThat(giftPrice).isEqualTo(expectedGiftPrice);
    }

    @DisplayName("크리스마스 이벤트 할인 가격을 계산")
    @ParameterizedTest
    @CsvSource({"1, 1000", "2, 1100", "25, 3400", "26, 0", "31, 0"})
    public void 크리스마스_이벤트_적용_후_혜택내역(Integer reserveDate, Integer expectedDiscountAmount) {
        //when
        Integer christmasDiscountAmount = Event.applyChristmasDiscount(reserveDate);

        //then
        assertThat(christmasDiscountAmount).isEqualTo(expectedDiscountAmount);
    }

    @DisplayName("평일 이벤트 할인 가격을 계산")
    @Test
    public void 평일_이벤트_적용_후_혜택내역() {
        //given
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.TBoneSteak, 1);
        orderItems.put(Menu.MushroomSoup, 2);
        orderItems.put(Menu.ChocolateCake, 1);
        orderItems.put(Menu.IceCream, 2);
        orderItems.put(Menu.RedWine, 1);

        Integer reserveDate = 19;

        //when
        Integer weekdayDiscountAmount = Event.applyWeekdayDiscount(reserveDate, orderItems);

        //then
        assertThat(weekdayDiscountAmount).isEqualTo(6069);
    }

    @DisplayName("주말 이벤트 할인 가격을 계산")
    @Test
    public void 주말_이벤트_적용_후_혜택내역() {
        //given
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.TBoneSteak, 1);
        orderItems.put(Menu.SeafoodPasta, 2);
        orderItems.put(Menu.MushroomSoup, 2);
        orderItems.put(Menu.IceCream, 2);
        orderItems.put(Menu.RedWine, 1);

        Integer reserveDate = 29;

        //when
        Integer holidayDiscountAmount = Event.applyHolidayDiscount(reserveDate, orderItems);

        //then
        assertThat(holidayDiscountAmount).isEqualTo(6069);
    }

    @DisplayName("특별 이벤트 할인 가격을 계산")
    @ParameterizedTest
    @CsvSource({"1, 0", "2, 0", "3, 1000", "10, 1000", "25, 1000", "30, 0"})
    public void 특별_할인_이벤트_적용_후_혜택내역(Integer reserveDate, Integer expectedDiscountAmount) {
        //when
        Integer specialDiscountAmount = Event.applySpecialDiscount(reserveDate);

        //then
        assertThat(specialDiscountAmount).isEqualTo(expectedDiscountAmount);
    }
}
