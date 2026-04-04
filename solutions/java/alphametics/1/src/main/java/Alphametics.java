import java.util.*;

class Alphametics {

    private final String[] leftWords;
    private final String rightWord;
    private final List<Character> letters;
    private final Set<Character> leadingLetters;

    Alphametics(String input) {

        String[] parts = input.split("==");
        String left = parts[0].trim();
        rightWord = parts[1].trim();

        leftWords = Arrays.stream(left.split("\\+"))
                .map(String::trim)
                .toArray(String[]::new);

        Set<Character> letterSet = new LinkedHashSet<>();
        leadingLetters = new HashSet<>();

        for (String word : leftWords) {
            for (char c : word.toCharArray()) {
                letterSet.add(c);
            }
            if (word.length() > 1) {
                leadingLetters.add(word.charAt(0));
            }
        }

        for (char c : rightWord.toCharArray()) {
            letterSet.add(c);
        }
        if (rightWord.length() > 1) {
            leadingLetters.add(rightWord.charAt(0));
        }

        letters = new ArrayList<>(letterSet);

        if (letters.size() > 10) {
            throw new IllegalArgumentException("Too many letters.");
        }
    }

    Map<Character, Integer> solve() throws UnsolvablePuzzleException {

        Map<Character, Integer> map = new HashMap<>();
        boolean[] used = new boolean[10];

        if (backtrack(0, map, used)) {
            return map;
        }

        throw new UnsolvablePuzzleException();
    }

    private boolean backtrack(int index, Map<Character, Integer> map, boolean[] used) {

        if (index == letters.size()) {
            return isValid(map);
        }

        char letter = letters.get(index);

        for (int digit = 0; digit <= 9; digit++) {

            if (used[digit]) continue;

            // Leading zero check
            if (digit == 0 && leadingLetters.contains(letter)) continue;

            map.put(letter, digit);
            used[digit] = true;

            if (backtrack(index + 1, map, used)) {
                return true;
            }

            map.remove(letter);
            used[digit] = false;
        }

        return false;
    }

    private boolean isValid(Map<Character, Integer> map) {

        long leftSum = 0;

        for (String word : leftWords) {
            leftSum += wordToNumber(word, map);
        }

        long rightValue = wordToNumber(rightWord, map);

        return leftSum == rightValue;
    }

    private long wordToNumber(String word, Map<Character, Integer> map) {

        long value = 0;

        for (char c : word.toCharArray()) {
            value = value * 10 + map.get(c);
        }

        return value;
    }
}