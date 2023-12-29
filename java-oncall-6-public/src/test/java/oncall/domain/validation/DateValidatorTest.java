package oncall.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DateValidatorTest {
    @DisplayName("month가 올바르지 않을 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"0.1", "-1", "13"})
    public void month가_올바르지_않은_경우(String month) {
        //when+then
        assertThatThrownBy(() -> DateValidator.validateAndReturnMonth(month))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }

    @DisplayName("요일이 올바르지 않을 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"김", "금요일"})
    public void 요일이_올바르지_않은_경우(String weekday) {
        //when+then
        assertThatThrownBy(() -> DateValidator.validateAndReturnMonth(weekday))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
}
