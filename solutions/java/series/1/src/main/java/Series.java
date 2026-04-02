import java.util.ArrayList;
import java.util.List;

class Series {
    private final int[] array;

    Series(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("series cannot be empty");
        }
        array = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            array[i] = string.charAt(i) - '0';
        }
    }

    List<String> slices(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        }
        if (num > array.length) {
            throw new IllegalArgumentException("slice length cannot be greater than series length");
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length - num + 1; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j < i + num; j++) {
                stringBuilder.append(array[j]);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }
}
