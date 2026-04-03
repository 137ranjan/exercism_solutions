import java.util.HashMap;
import java.util.Map;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        input = input.toLowerCase().trim();
        Map<String, Integer> wordCount = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c) || (isValidApostrophe(c, input, i))) {
                sb.append(c);
            } else if (!sb.isEmpty()) {
                wordCount.merge(sb.toString(), 1, Integer::sum);
                sb.setLength(0);
            }
        }
        if (!sb.isEmpty()) {
            wordCount.merge(sb.toString(), 1, Integer::sum);
        }
        return wordCount;
    }

    private boolean isValidApostrophe(char c, String input, int i) {
        return c == '\'' && i > 0 && i < input.length() - 1 &&
                Character.isLetterOrDigit(input.charAt(i - 1)) &&
                Character.isLetterOrDigit(input.charAt(i + 1));
    }
}
