class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int sum = 0;
        int num = numberToCheck;
        int numOfDigits = String.valueOf(numberToCheck).length();
        
        while(numberToCheck != 0){
            int rem = numberToCheck%10;
            sum += Math.pow(rem, numOfDigits);
            numberToCheck = numberToCheck/10;
        }
        if(sum == num){
            return true;
        }
        return false;

    }

}
