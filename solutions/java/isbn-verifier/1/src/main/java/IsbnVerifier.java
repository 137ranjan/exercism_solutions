class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String cleanedString = stringToVerify.replace("-", "");

        if(cleanedString.length() != 10){
            return false;
        }

        int sum = 0;
        for(int i=0; i<9; i++){
            char c = cleanedString.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
            sum += (c - '0')*(10 - i);
        }

        char lastChar = cleanedString.charAt(9);
        int lastDigit;
        if(lastChar == 'X'){
            lastDigit = 10;
        }else if(Character.isDigit(lastChar)){
            lastDigit = lastChar - '0';
        }else{
            return false;
        }
        sum += lastDigit*1;

        return (sum % 11 == 0);
    }

}
