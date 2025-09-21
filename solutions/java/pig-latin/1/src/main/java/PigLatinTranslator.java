class PigLatinTranslator {
    public String translate(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) result.append(" ");
            result.append(translateWord(words[i]));
        }
        return result.toString();
    }

    private String translateWord(String word) {
        // Rule 1: Starts with vowel or "xr"/"yt"
        if (startsWithVowel(word) || word.startsWith("xr") || word.startsWith("yt")) {
            return word + "ay";
        }

        // Rule 3: Starts with consonant(s) followed by "qu"
        if (word.matches("^[^aeiou]*qu.*")) {
            int quIndex = word.indexOf("qu");
            return word.substring(quIndex + 2) + word.substring(0, quIndex + 2) + "ay";
        }

        // Rule 4: Consonant(s) followed by "y"
        int yIndex = word.indexOf('y');
        if (yIndex > 0 && allConsonants(word.substring(0, yIndex))) {
            return word.substring(yIndex) + word.substring(0, yIndex) + "ay";
        }

        // Rule 2: Move leading consonant(s) to end, add "ay"
        int firstVowel = firstVowelIndex(word);
        if (firstVowel > 0) {
            return word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
        }

        // Fallback (should not be reached)
        return word + "ay";
    }

    private boolean startsWithVowel(String word) {
        return word.matches("^[aeiou].*");
    }

    private boolean isConsonant(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) == -1;
    }

    private boolean allConsonants(String s) {
        for (char c : s.toCharArray()) {
            if (!isConsonant(c)) return false;
        }
        return true;
    }

    private int firstVowelIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                return i;
            }
        }
        return -1;
    }

}