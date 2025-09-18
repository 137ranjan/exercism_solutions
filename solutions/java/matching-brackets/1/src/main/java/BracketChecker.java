import java.util.Stack;

class BracketChecker {

    private final String expression;

    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> stack = new Stack<>();
        for (char character : expression.toCharArray()) {
            if (character == '{' || character == '(' || character == '[') {
                stack.push(character);
            } else if (character == '}' || character == ')' || character == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char poppedCharacter = stack.pop();
                if (!isMatchingPair(poppedCharacter, character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatchingPair(char poppedCharacter, char character) {
        return (poppedCharacter == '{' && character == '}') ||
                (poppedCharacter == '(' && character == ')') ||
                (poppedCharacter == '[' && character == ']');
    }

}