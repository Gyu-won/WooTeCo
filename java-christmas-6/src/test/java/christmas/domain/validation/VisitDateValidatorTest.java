package christmas.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateValidatorTest {
    @DisplayName("올바르지 않은 방문 날짜에 대한 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"타파스", "0", "0.5", "32"})
    public void 방문날짜가_올바르지_않은_경우(String invalidVisitDateInput) {
        //when+then
        assertThatThrownBy(() -> VisitDateValidator.validateAndReturn(invalidVisitDateInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
