import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    private final int level;
    private final int[] magicalItemArray;

    SumOfMultiples(int number, int[] set) {
        level = number;
        magicalItemArray = set;
    }

    int getSum() {
        Set<Integer> finalValidMultiplesSet = new HashSet<>();
        for (int magicalItemValue : magicalItemArray) {
            finalValidMultiplesSet.addAll(getValidMultiples(magicalItemValue));
        }

        return finalValidMultiplesSet.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Set<Integer> getValidMultiples(int magicalItemValue) {
        Set<Integer> validMultiples = new HashSet<>();
        if (magicalItemValue <= 0) {
            return validMultiples;
        }
        for (int i = magicalItemValue; i < level; i += magicalItemValue) {
            validMultiples.add(i);
        }
        return validMultiples;
    }
}
