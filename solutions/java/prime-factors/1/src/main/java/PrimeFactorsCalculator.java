import java.util.List;

class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long number) {
        int factor = 2;
        List<Long> primeFactors = new java.util.ArrayList<>();
        while (number > 1) {
            while (number % factor == 0) {
                primeFactors.add((long) factor);
                number /= factor;
            }
            factor++;
        }
        return primeFactors;
    }
}