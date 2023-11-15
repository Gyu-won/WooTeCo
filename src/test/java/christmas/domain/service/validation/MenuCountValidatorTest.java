package christmas.domain.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuCountValidatorTest {
    @DisplayName("메뉴 개수를 올바르게 입력하지 않으면 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "0.5", "-3"})
    public void 메뉴_개수를_올바르게_입력한_경우(String countInput) {
        //when+then
        assertThatThrownBy(() -> MenuCountValidator.validate(countInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

}
