package ch02;

public class PasswordStrengthMeter {

    private static final int PASSWORD_LENGTH_MINIMUM = 8;

    public PasswordStrength meter(final String password) {
        if (password.length() < PASSWORD_LENGTH_MINIMUM) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
