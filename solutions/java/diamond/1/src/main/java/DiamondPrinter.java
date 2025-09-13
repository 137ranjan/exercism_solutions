import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    public List<String> printToList(char letter) {
        List<String> result = new ArrayList<>();
        int maxIndex = letter - 'A';

        // Build the top half including the middle line
        for (int i = 0; i <= maxIndex; i++) {
            result.add(buildLine(i, maxIndex));
        }

        // Mirror the top half excluding the middle line
        for (int i = maxIndex - 1; i >= 0; i--) {
            result.add(buildLine(i, maxIndex));
        }

        return result;
    }

    private String buildLine(int index, int maxIndex) {
    char currentChar = (char) ('A' + index);
    int totalWidth = 2 * maxIndex + 1;
    StringBuilder line = new StringBuilder();

    // Leading spaces
    for (int i = 0; i < maxIndex - index; i++) {
        line.append(' ');
    }

    // First letter
    line.append(currentChar);

    // Inner spaces and second letter (if index > 0)
    if (index > 0) {
        for (int i = 0; i < 2 * index - 1; i++) {
            line.append(' ');
        }
        line.append(currentChar);
    }

    // Trailing spaces (to make length == totalWidth)
    while (line.length() < totalWidth) {
        line.append(' ');
    }

    return line.toString();
}
}
