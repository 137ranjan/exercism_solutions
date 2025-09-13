public class PangramChecker {

    public boolean isPangram(String input) {
        input = input.toLowerCase();
        int[] freqArr = new int[26];
        for(int i=0; i<input.length(); i++){
            char currChar = input.charAt(i);
            if(currChar >= 'a' && currChar <= 'z'){
                freqArr[currChar - 'a']++;
            }
        }

        for(int i=0; i<freqArr.length; i++){
            if(freqArr[i] == 0){
                return false;
            }
        }

        return true;
    }

}
