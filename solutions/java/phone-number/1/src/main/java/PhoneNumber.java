class PhoneNumber {

    private static final int MIN_LENGTH = 10;
    private static final int MAX_LENGTH = 11;
    private static final char COUNTRY_CODE = '1';

    private static final String ERR_LETTERS = "letters not permitted";
    private static final String ERR_PUNCTUATION = "punctuations not permitted";
    private static final String ERR_TOO_FEW = "must not be fewer than 10 digits";
    private static final String ERR_TOO_MANY = "must not be greater than 11 digits";
    private static final String ERR_11_START = "11 digits must start with 1";
    private static final String ERR_AREA_ZERO = "area code cannot start with zero";
    private static final String ERR_AREA_ONE = "area code cannot start with one";
    private static final String ERR_EXCH_ZERO = "exchange code cannot start with zero";
    private static final String ERR_EXCH_ONE = "exchange code cannot start with one";

    private final String cleanedNumber;

    PhoneNumber(String numberString) {
        String digits = extractDigits(numberString);
        this.cleanedNumber = validateAndFormat(digits);
    }

    String getNumber() {
        return cleanedNumber;
    }

    private String extractDigits(String input) {
        StringBuilder digits = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                throw new IllegalArgumentException(ERR_LETTERS);
            } else if (Character.isDigit(ch)) {
                digits.append(ch);
            } else if (isPunctuation(ch)) {
                throw new IllegalArgumentException(ERR_PUNCTUATION);
            }
        }
        return digits.toString();
    }

    private boolean isPunctuation(char ch) {
        return ch == '!' || ch == '@' || ch == ':';
    }

    private String validateAndFormat(String digits) {
        int length = digits.length();
        if (length < MIN_LENGTH) {
            throw new IllegalArgumentException(ERR_TOO_FEW);
        }
        if (length > MAX_LENGTH) {
            throw new IllegalArgumentException(ERR_TOO_MANY);
        }
        if (length == MAX_LENGTH) {
            if (digits.charAt(0) != COUNTRY_CODE) {
                throw new IllegalArgumentException(ERR_11_START);
            }
            digits = digits.substring(1);
        }
        if (digits.charAt(0) == '0') {
            throw new IllegalArgumentException(ERR_AREA_ZERO);
        }
        if (digits.charAt(0) == '1') {
            throw new IllegalArgumentException(ERR_AREA_ONE);
        }
        if (digits.charAt(3) == '0') {
            throw new IllegalArgumentException(ERR_EXCH_ZERO);
        }
        if (digits.charAt(3) == '1') {
            throw new IllegalArgumentException(ERR_EXCH_ONE);
        }
        return digits;
    }

}