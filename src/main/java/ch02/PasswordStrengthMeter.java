package ch02;

public class PasswordStrengthMeter {

    private static final int PASSWORD_LENGTH_MINIMUM = 8;

    public PasswordStrength meter(final String password) {
        if (isNullOrEmpty(password)) {
            return PasswordStrength.INVALID;
        }
        if (isUnderValidLength(password) || !(isContainsNumber(password))) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean isNullOrEmpty(final String password) {
        return password == null || password.isEmpty();
    }

    private boolean isUnderValidLength(final String password) {
        return password.length() < PASSWORD_LENGTH_MINIMUM;
    }

    private boolean isContainsNumber(final String password) {
        for (String text : password.split("")) {
            if (text.matches("[0-9]+")) {
                return true;
            }
        }
        return false;
    }
}
