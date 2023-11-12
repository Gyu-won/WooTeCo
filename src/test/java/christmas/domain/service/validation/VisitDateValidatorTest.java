package christmas.domain.service.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateValidatorTest {

    @DisplayName("방문 날짜는 1부터 31까지의 숫자가 아니면 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"c", "dk", "-1", "0", "32", "1.8", "2 "})
    public void 방문_날짜가_유효하지_않은_경우(String visitDate) {
        //when
        assertThatThrownBy(() -> VisitDate.validate(visitDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("방문 날짜는 1부터 31까지의 숫자이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "31"})
    public void 방문_날짜가_유효한_경우(String visitDate) {
        //when
        Integer actualVisitDate = VisitDate.validate(visitDate);

        //then
        assertThat(actualVisitDate).isEqualTo(Integer.parseInt(visitDate));
    }
}
