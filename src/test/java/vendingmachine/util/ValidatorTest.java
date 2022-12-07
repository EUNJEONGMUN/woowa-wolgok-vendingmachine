package vendingmachine.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @DisplayName("숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12*", "!!", "123%"})
    void validIsNumber(String input) {
        Assertions.assertThatThrownBy(() -> Validator.validIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해야 합니다.");
    }

    @DisplayName("상품끼리는 ;로 구분해야 한다.")
    @Test
    void validProductInfoShape1() {
        Assertions.assertThatThrownBy(() -> Validator.validProductInfoShape("[콜라, 1000, 10]/[사이다, 1000, 10]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
    }

    @DisplayName("상품명, 수량, 가격은 쉼표로 구분해야 한다.")
    @Test
    void validProductInfoShape2() {
        Assertions.assertThatThrownBy(() -> Validator.validProductInfoShape("[콜라| 1000| 10]/[사이다, 1000, 10]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
    }


    @DisplayName("수량과 가격은 숫자로 입력해야 한다.")
    @Test
    void validProductInfoShape3() {
        Assertions.assertThatThrownBy(() -> Validator.validProductInfoShape("[콜라, ,1000, a]/[사이다, a, 10]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
    }
}