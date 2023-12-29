package christmas.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderValidatorTest {
    @DisplayName("올바르지 않은 주문에 대한 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,제로콜라", "타파스-1,타파스-2", "김치찌개-1,제로콜라-1", "타파스-0.5", "타파스-0", "타파스-15,타파스-1,제로콜라-10"})
    public void 주문이_올바르지_않은_경우(String invalidMenuInput) {
        //when+then
        assertThatThrownBy(() -> OrderValidator.validateAndReturn(invalidMenuInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
