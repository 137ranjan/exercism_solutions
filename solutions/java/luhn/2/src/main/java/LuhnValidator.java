class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate == null) return false;

        String sanitized = candidate.replaceAll(" ", "");
        if (sanitized.length() < 2 || !sanitized.chars().allMatch(Character::isDigit)) {
            return false;
        }

        int sum = 0;
        boolean doubleDigit = false;

        // Process digits from right to left
        for (int i = sanitized.length() - 1; i >= 0; i--) {
            int digit = sanitized.charAt(i) - '0';
            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }
            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}
