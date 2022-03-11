package ch02;

public class PasswordStrengthMeter {

    private static final int PASSWORD_LENGTH_MINIMUM = 8;

    public PasswordStrength meter(final String password) {
        if (isNullOrEmpty(password)) {
            return PasswordStrength.INVALID;
        }
        if (isNormal(password)) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean isNullOrEmpty(final String string) {
        return string == null || string.isEmpty();
    }

    private boolean isNormal(final String password) {
        return isUnderValidLength(password) || isNotContainsNumber(password) || isNotContainsCapital(password);
    }

    private boolean isUnderValidLength(final String string) {
        return string.length() < PASSWORD_LENGTH_MINIMUM;
    }

    private boolean isNotContainsNumber(final String string) {
        for (String text : string.split("")) {
            if (text.matches("[0-9]+")) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotContainsCapital(final String string) {
        for (String text : string.split("")) {
            if (text.matches("[A-Z]+")) {
                return false;
            }
        }
        return true;
    }
}
