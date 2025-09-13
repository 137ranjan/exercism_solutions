class SqueakyClean {
    static String clean(String identifier) {
        char[] charArr = identifier.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<charArr.length; i++){
            if(Character.isISOControl(charArr[i])){
                sb.append("CTRL");
            }else if(charArr[i] == ' '){
                sb.append("_");
            }else if(charArr[i] == '-'){
                i++;
                if(Character.isLetter(charArr[i])){
                    sb.append(Character.toUpperCase(charArr[i]));
                }
                
            }else if(charArr[i] >= 'α' && charArr[i] <= 'ω'){
                continue;
            }
            else if(Character.isLetter(charArr[i])){
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }
}
