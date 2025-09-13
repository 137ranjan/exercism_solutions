import java.util.*;

class TwelveDays {
    private final String line;
    private final Map<Integer, List<String>> wordMap;

    TwelveDays() {
        line = "On the %s day of Christmas my true love gave to me: ";
        wordMap = new HashMap<>();
        wordMap.put(1, new ArrayList<>(Arrays.asList("first", "a Partridge in a Pear Tree")));
        wordMap.put(2, new ArrayList<>(Arrays.asList("second", "two Turtle Doves")));
        wordMap.put(3, new ArrayList<>(Arrays.asList("third", "three French Hens")));
        wordMap.put(4, new ArrayList<>(Arrays.asList("fourth", "four Calling Birds")));
        wordMap.put(5, new ArrayList<>(Arrays.asList("fifth", "five Gold Rings")));
        wordMap.put(6, new ArrayList<>(Arrays.asList("sixth", "six Geese-a-Laying")));
        wordMap.put(7, new ArrayList<>(Arrays.asList("seventh", "seven Swans-a-Swimming")));
        wordMap.put(8, new ArrayList<>(Arrays.asList("eighth", "eight Maids-a-Milking")));
        wordMap.put(9, new ArrayList<>(Arrays.asList("ninth", "nine Ladies Dancing")));
        wordMap.put(10, new ArrayList<>(Arrays.asList("tenth", "ten Lords-a-Leaping")));
        wordMap.put(11, new ArrayList<>(Arrays.asList("eleventh", "eleven Pipers Piping")));
        wordMap.put(12, new ArrayList<>(Arrays.asList("twelfth", "twelve Drummers Drumming")));
    }

    String verse(int verseNumber) {
        if (verseNumber == 1) {
            return String.format(line, wordMap.get(1).get(0)) + wordMap.get(1).get(1) + ".\n";
        }
        StringBuilder verseStringBuilder = new StringBuilder(String.format(line, wordMap.get(verseNumber).get(0)));
        for (int i = verseNumber; i > 1; i--) {
            verseStringBuilder.append(wordMap.get(i).get(1));
            verseStringBuilder.append(", ");
        }
        verseStringBuilder.append("and ");
        verseStringBuilder.append(wordMap.get(1).get(1));
        verseStringBuilder.append(".\n");
        return verseStringBuilder.toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = startVerse; i < endVerse; i++) {
            stringBuilder.append(verse(i)).append("\n");
        }
        stringBuilder.append(verse(endVerse));
        return stringBuilder.toString();
    }

    String sing() {
        return verses(1, 12);
    }
}
