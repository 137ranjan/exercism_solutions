class RotationalCipher {
    private int shiftKey;
    
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        char[] dataArr = data.toCharArray();
        for(int i=0; i<dataArr.length; i++){
            if(Character.isLetter(dataArr[i])){
                int finalChar = (int)dataArr[i] + shiftKey;
                if(Character.isLowerCase(dataArr[i]) && (finalChar >= 'a' && finalChar <= 'z')){
                    dataArr[i] = (char)finalChar;
                }else if(Character.isUpperCase(dataArr[i]) && (finalChar >='A' && finalChar <= 'Z')){
                    dataArr[i] = (char)finalChar;
                }else{
                    dataArr[i] = (char)(finalChar - 26);
                }
            }  
        }
        String result = new String(dataArr);
        return result;
    }

}
