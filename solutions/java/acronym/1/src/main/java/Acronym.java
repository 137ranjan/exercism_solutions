class Acronym {
    private String acronym;
    Acronym(String phrase) {
        char[] charArr = phrase.toCharArray();
        StringBuilder sb = new StringBuilder();
        if((charArr[0] >= 'a' && charArr[0] <= 'z') || (charArr[0] >= 'A' && charArr[0] <= 'Z')){
            sb.append(Character.toUpperCase(charArr[0]));
        }

        for(int i=1; i<charArr.length; i++){
            if( (charArr[i-1] == ' ' || charArr[i-1] == '-' || charArr[i-1] == '_') && 
                  ((charArr[i] >= 'a' && charArr[i] <= 'z') || 
                  (charArr[i] >= 'A' && charArr[i] <= 'Z'))){
                sb.append(Character.toUpperCase(charArr[i]));
                }
        }

        this.acronym = sb.toString();
    }

    String get() {
        return this.acronym;
    }

}
