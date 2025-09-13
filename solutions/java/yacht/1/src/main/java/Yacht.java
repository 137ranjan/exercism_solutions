import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {

        Map<Integer, Long> counts = getDiceCounts();

        switch (yachtCategory) {
            case ONES -> {
                return (int) (counts.getOrDefault(1, 0L) * 1);
            }
            case TWOS -> {
                return (int) (counts.getOrDefault(2, 0L) * 2);
            }
            case THREES -> {
                return (int) (counts.getOrDefault(3, 0L) * 3);
            }
            case FOURS -> {
                return (int) (counts.getOrDefault(4, 0L) * 4);
            }
            case FIVES -> {
                return (int) (counts.getOrDefault(5, 0L) * 5);
            }
            case SIXES -> {
                return (int) (counts.getOrDefault(6, 0L) * 6);
            }
            case FULL_HOUSE -> {
                if (counts.size() == 2 && counts.containsValue(2L) && counts.containsValue(3L)) {
                    return Arrays.stream(dice).sum();
                }
                return 0;
            }
            case FOUR_OF_A_KIND -> {
                int fourOfAKindValue = getValueOfNofAKind(counts, 4);
                if (fourOfAKindValue != 0) {
                    return fourOfAKindValue * 4;
                }
                return 0;
            }
            case LITTLE_STRAIGHT -> {
                return isStraight(counts, 1) ? 30 : 0;
            }
            case BIG_STRAIGHT -> {
                return isStraight(counts, 2) ? 30 : 0;
            }
            case CHOICE -> {
                return Arrays.stream(dice).sum();
            }
            case YACHT -> {
                if (counts.size() == 1 && counts.containsValue(5L)) {
                    return 50;
                }
                return 0;
            }
            default -> {
                return 0;
            }
        }
    }

    // Helper method to check if a specific N-of-a-kind exists
    private static boolean hasNofAKind(Map<Integer, Long> counts, int n) {
        return counts.values().stream().anyMatch(count -> count >= n);
    }

    // Helper method to count frequencies of each die face
    private Map<Integer, Long> getDiceCounts() {
        return Arrays.stream(dice)
                .boxed() //convert int to Integer for collecting
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // Helper method to get the value of the die that forms an N-of-a-kind
    // Returns 0 if not found. Assumes only one such value is relevant for scoring
    private int getValueOfNofAKind(Map<Integer, Long> counts, int n) {
        return counts.entrySet().stream()
                .filter(entry -> entry.getValue() >= n)
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    // Helper method to check for a straight (e.g., 1-2-3-4-5 or 2-3-4-5-6)
    private boolean isStraight(Map<Integer, Long> counts, int startValue) {
        // a straight must have 5 unique dice, each with a count of 1
        if (counts.size() != 5) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (counts.getOrDefault(startValue + i, 0L) != 1) {
                return false;
            }
        }
        return true;
    }

}
