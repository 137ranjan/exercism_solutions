class PrimeCalculator {

    int nth(int nth) {
        if (nth <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer (nth > 0).");
        }

        int count = 0;
        int number = 1;

        while (count < nth) {
            number++;
            if (isPrime(number)) {
                count++;
            }
        }

        return number;
    }

    private boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
