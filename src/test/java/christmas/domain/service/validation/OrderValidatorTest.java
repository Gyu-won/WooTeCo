package christmas.domain.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderValidatorTest {
    @DisplayName("음료만 주문 시 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-3", "레드와인-1,샴폐인1"})
    public void 음료만_주문한_경우(String menusInput) {
        //when+then
        assertThatThrownBy(() -> OrderValidator.validate(menusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("주문메뉴가 20개를 초과하는 경우 에러를 발생시킨다")
    @Test
    public void 주문메뉴가_20개를_초과한_경우() {
        //given
        String menusInput = "양송이수프-6,티본스테이크-6,초코케이크-3,제로콜라-6";

        //when+then
        assertThatThrownBy(() -> OrderValidator.validate(menusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
