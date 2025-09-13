class LargestSeriesProductCalculator {
    private final String inputNumber;
    
    LargestSeriesProductCalculator(String inputNumber) {
        for(int i=0; i<inputNumber.length(); i++){
            if(!Character.isDigit(inputNumber.charAt(i))){
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(numberOfDigits > inputNumber.length()){
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        if(numberOfDigits < 0){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        long largestSeriesProduct = 0;
        for(int i=0; i < inputNumber.length() - numberOfDigits + 1; i++){
            long seriesProduct = 1;
            for(int j=i; j < i+numberOfDigits; j++){
                seriesProduct *= Character.getNumericValue(inputNumber.charAt(j));
                // seriesProduct *= inputNumber.charAt(j) - '0';
            }
            largestSeriesProduct = Math.max(largestSeriesProduct, seriesProduct);
        }
        return largestSeriesProduct;
    }
}
