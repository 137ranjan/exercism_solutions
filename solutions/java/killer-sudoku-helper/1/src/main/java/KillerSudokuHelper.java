import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KillerSudokuHelper {

    public List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> allCombinations = findCombinations(cageSum, cageSize);
        if (exclude == null || exclude.isEmpty()) {
            return allCombinations.stream()
                    .map(Collections::unmodifiableList)
                    .collect(Collectors.toList());
        }

        Set<Integer> excludedDigits = new HashSet<>(exclude);
        return allCombinations.stream()
                .filter(combination -> combination.stream().noneMatch(excludedDigits::contains))
                .map(Collections::unmodifiableList)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return findCombinations(cageSum, cageSize).stream()
                .map(combination -> Collections.unmodifiableList(new ArrayList<>(combination)))
                .collect(Collectors.toList());
    }

    private List<List<Integer>> findCombinations(int targetSum, int size) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsRecursive(targetSum, size, 1, new ArrayList<>(), result);
        return result.stream()
                .sorted((list1, list2) -> {
                    for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                        int compare = list1.get(i).compareTo(list2.get(i));
                        if (compare != 0) {
                            return compare;
                        }
                    }
                    return Integer.compare(list1.size(), list2.size());
                })
                .collect(Collectors.toList());
    }

    private void findCombinationsRecursive(int remainingSum, int remainingSize, int startDigit, List<Integer> currentCombination, List<List<Integer>> result) {
        if (remainingSize == 0) {
            if (remainingSum == 0) {
                result.add(new ArrayList<>(currentCombination));
            }
            return;
        }

        if (remainingSum <= 0) {
            return;
        }

        for (int digit = startDigit; digit <= 9; digit++) {
            if (!currentCombination.contains(digit) && remainingSum >= digit) {
                currentCombination.add(digit);
                findCombinationsRecursive(remainingSum - digit, remainingSize - 1, digit + 1, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1); // Backtrack
            }
        }
    }
}