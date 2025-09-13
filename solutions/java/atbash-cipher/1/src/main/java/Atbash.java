class Atbash {
    
    String encode(String input) {
        StringBuilder sb = new StringBuilder();
        int groupSize = 0;
        for(int i=0; i<input.length(); i++){
            char ch = Character.toLowerCase(input.charAt(i));
            if(!(Character.isLetter(ch) || Character.isDigit(ch))) continue;
            if(groupSize == 5) {
                sb.append(" ");
                groupSize = 0;
            }
            if(Character.isLetter(ch)){
                sb.append((char)('z' - ch + 97));
                groupSize++;
            }else{
                sb.append(ch);
                groupSize++;
            }
        }
        return sb.toString();
    }

    String decode(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch != ' '){
                if(Character.isDigit(ch)){
                    sb.append(ch);
                    continue;
                }
                sb.append((char) (Math.abs(ch - 'z') + 97));
            } 
        }
        return sb.toString();
    }

}
