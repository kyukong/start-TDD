package ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    /**
     * TDD 예: 암호 검사기
     *
     * 검사할 항목
     * - 길이가 8 글자 이상
     * - 0 부터 9 사이의 숫자를 포함
     * - 대문자 포함
     * - 세 규칙을 모두 충족하면 암호는 강함이다.
     * - 2 개의 규칙을 충족하면 암호는 보통이다.
     * - 1 개 이하의 규칙을 충족하면 암호는 약함이다.
     */

    @DisplayName("null 을 입력한 경우")
    @Test
    void password_null() {
        assertEquals(meter.meter(null), PasswordStrength.INVALID);
    }

    @DisplayName("빈 값을 입력한 경우")
    @Test
    void password_empty() {
        assertEquals(meter.meter(""), PasswordStrength.INVALID);
    }

    @DisplayName("모든 조건을 만족하는 경우")
    @Test
    void strong() {
        assertEquals(meter.meter("1234ABCD"), PasswordStrength.STRONG);
    }

    @DisplayName("길이가 8 글자 미만이며 다른 조건은 만족하는 경우")
    @Test
    void normal_length_under_8() {
        assertEquals(meter.meter("123ABCD"), PasswordStrength.NORMAL);
    }

    @DisplayName("숫자를 포함하지 않으며 다른 조건은 만족하는 경우")
    @Test
    void normal_not_contains_number() {
        assertEquals(meter.meter("ABCDEFGH"), PasswordStrength.NORMAL);
    }

    @DisplayName("대문자를 포함하지 않으며 다른 조건은 만족하는 경우")
    @Test
    void normal_not_contains_capital() {
        assertEquals(meter.meter("1234abcd"), PasswordStrength.NORMAL);
    }

    // TODO: 길이가 7 글자이며 0 부터 9 사이의 숫자를 포함하지 않는 경우 -> 약함

    // TODO: 길이가 7 글자이며 대문자를 포함하지 않는 경우 -> 약함

    // TODO: 0 부터 9 사이의 숫자를 포함하지 않으며 대문자를 포함하지 않는 경우 -> 약함

    // TODO: 모든 검증 실패
}
