public class AffineCipher {

    private static final int M = 26;

    public String encode(String text, int a, int b) {
        validateKey(a);

        StringBuilder encoded = new StringBuilder();
        int count = 0;

        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                int x = ch - 'a';
                int encodedVal = mod(a * x + b, M);
                char encodedChar = (char) ('a' + encodedVal);

                if (count == 5) {
                    encoded.append(' ');
                    count = 0;
                }

                encoded.append(encodedChar);
                count++;
            } else if (Character.isDigit(ch)) {
                if (count == 5) {
                    encoded.append(' ');
                    count = 0;
                }

                encoded.append(ch);
                count++;
            }
        }
        return encoded.toString();
    }

    public String decode(String text, int a, int b) {
        validateKey(a);

        int aInverse = modularInverse(a, M);
        StringBuilder decoded = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int y = ch - 'a';
                int decodedVal = mod(aInverse * (y - b), M);
                decoded.append((char) ('a' + decodedVal));
            } else if (Character.isDigit(ch)) {
                decoded.append(ch);
            }
        }
        return decoded.toString();
    }

    private void validateKey(int a) {
        if (gcd(a, M) != 1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int modularInverse(int a, int m) {
        // brute force (m is small=26)
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }

        throw new IllegalArgumentException("No modular inverse found");
    }

    private int mod(int x, int m) {
        return (x % m + m) % m;
    }
}