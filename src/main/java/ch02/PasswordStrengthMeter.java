package ch02;

public class PasswordStrengthMeter {

    private static final int PASSWORD_LENGTH_MINIMUM = 8;
    private static final int MEET_WEAK = 1;
    private static final int MEET_NORMAL = 2;

    public PasswordStrength meter(final String password) {
        if (isNullOrEmpty(password)) {
            return PasswordStrength.INVALID;
        }
        int meet = checkConditions(password);
        if (meet == MEET_WEAK) {
            return PasswordStrength.WEAK;
        }
        if (meet == MEET_NORMAL) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private int checkConditions(final String password) {
        int meet = 0;
        if (isOverValidLength(password)) {
            meet++;
        }
        if (isContainsNumber(password)) {
            meet++;
        }
        if (isContainsCapital(password)) {
            meet++;
        }
        return meet;
    }

    private boolean isNullOrEmpty(final String string) {
        return string == null || string.isEmpty();
    }

    private boolean isOverValidLength(final String string) {
        return string.length() >= PASSWORD_LENGTH_MINIMUM;
    }

    private boolean isContainsNumber(final String string) {
        for (String text : string.split("")) {
            if (text.matches("[0-9]+")) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainsCapital(final String string) {
        for (String text : string.split("")) {
            if (text.matches("[A-Z]+")) {
                return true;
            }
        }
        return false;
    }
}
