import java.util.*;

class BaseConverter {

    private final int originalBase;
    private final int[] originalDigits;

    BaseConverter(int originalBase, int[] originalDigits) {

        if (originalBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        for (int digit : originalDigits) {
            if (digit < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }
            if (digit >= originalBase) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
        }

        this.originalBase = originalBase;
        this.originalDigits = Arrays.copyOf(originalDigits, originalDigits.length);
    }

    int[] convertToBase(int newBase) {

        if (newBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        // Handle empty input
        if (originalDigits.length == 0) {
            return new int[]{0};
        }

        // Remove leading zeros
        int index = 0;
        while (index < originalDigits.length && originalDigits[index] == 0) {
            index++;
        }

        // If all zeros
        if (index == originalDigits.length) {
            return new int[]{0};
        }

        // Step 1: Convert to decimal
        int decimalValue = 0;
        for (int i = index; i < originalDigits.length; i++) {
            decimalValue = decimalValue * originalBase + originalDigits[i];
        }

        // Step 2: Convert decimal → new base
        List<Integer> result = new ArrayList<>();

        while (decimalValue > 0) {
            result.add(decimalValue % newBase);
            decimalValue /= newBase;
        }

        Collections.reverse(result);

        return result.stream().mapToInt(i -> i).toArray();
    }
}