class Bob {

    String hey(String input) {
        boolean isQuestion = isQuestion(input);
        boolean isAllCaps = isAllCaps(input);
        boolean isSilence = isSilence(input);
        //System.out.println("isQuestion:"+isQuestion);
        //System.out.println("isAllCaps:"+isAllCaps);
        //System.out.println("isSilence:"+isSilence);
        
        if(isQuestion && isAllCaps){
            return "Calm down, I know what I'm doing!";
        }
        if(isQuestion){
            return "Sure.";
        }
        if(isAllCaps){
            return "Whoa, chill out!";
        }
        if(isSilence){
            return "Fine. Be that way!";
        }
        return "Whatever.";
    }

    private boolean isQuestion(String input){
        input = input.trim();
        if(input == null || input.length() == 0){ return false;}
        char lastCharacter = input.charAt(input.length() - 1);
        System.out.println("lastCharacter = "+lastCharacter);
        return lastCharacter == '?';
    }

    private boolean isAllCaps(String input){
        boolean flag = false;
        for(int i=0; i<input.length(); i++){
            if(Character.isLetter(input.charAt(i)) && input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
                flag = true;
            }else if(Character.isLetter(input.charAt(i)) 
                     && input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean isSilence(String input){
        input = input.trim();
        //System.out.println("input.length()"+input.length());
        if(input == null || input.length() == 0){
            return true;
        }
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) != ' ' && input.charAt(i) != '\t' && input.charAt(i) != '\r'){
                return false;
            }
        }
        return true;
    }

}