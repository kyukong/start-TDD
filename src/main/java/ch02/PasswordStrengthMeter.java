package ch02;

public class PasswordStrengthMeter {

    private static final int PASSWORD_LENGTH_MINIMUM = 8;

    public PasswordStrength meter(final String password) {
        if (isNullOrEmpty(password)) {
            return PasswordStrength.INVALID;
        }
        if (isWeak(password)) {
            return PasswordStrength.WEAK;
        }
        if (isNormal(password)) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean isNullOrEmpty(final String string) {
        return string == null || string.isEmpty();
    }

    private boolean isWeak(final String string) {
        return (isOverValidLength(string) && !isContainsNumber(string) && !isContainsCapital(string))
                || (!isOverValidLength(string) && isContainsNumber(string) && !isContainsCapital(string));
    }

    private boolean isNormal(final String string) {
        return !isOverValidLength(string) || !isContainsNumber(string) || !isContainsCapital(string);
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
