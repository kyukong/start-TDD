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
        assertEquals(PasswordStrength.INVALID, meter.meter(null));
    }

    @DisplayName("빈 값을 입력한 경우")
    @Test
    void password_empty() {
        assertEquals(PasswordStrength.INVALID, meter.meter(""));
    }

    @DisplayName("모든 조건을 만족하는 경우")
    @Test
    void strong() {
        assertEquals(PasswordStrength.STRONG, meter.meter("1234ABCD"));
    }

    @DisplayName("길이가 8 글자 미만이며 다른 조건은 만족하는 경우")
    @Test
    void normal_length_under_8() {
        assertEquals(PasswordStrength.NORMAL, meter.meter("123ABCD"));
    }

    @DisplayName("숫자를 포함하지 않으며 다른 조건은 만족하는 경우")
    @Test
    void normal_not_contains_number() {
        assertEquals(PasswordStrength.NORMAL, meter.meter("ABCDEFGH"));
    }

    @DisplayName("대문자를 포함하지 않으며 다른 조건은 만족하는 경우")
    @Test
    void normal_not_contains_capital() {
        assertEquals(PasswordStrength.NORMAL, meter.meter("1234abcd"));
    }

    @DisplayName("길이가 8 글자 이상인 조건만 만족하는 경우")
    @Test
    void weak_only_length_over_8() {
        assertEquals(PasswordStrength.WEAK, meter.meter("abcdefgh"));
    }

    @DisplayName("숫자 포함 조건만 만족하는 경우")
    @Test
    void weak_only_contains_number() {
        assertEquals(PasswordStrength.WEAK, meter.meter("1234567"));
    }

    @DisplayName("대문자 포함 조건만 만족하는 경우")
    @Test
    void weak_only_contains_capital() {
        assertEquals(PasswordStrength.WEAK, meter.meter("ABCDEFG"));
    }

    // TODO: 모든 검증 실패
}
