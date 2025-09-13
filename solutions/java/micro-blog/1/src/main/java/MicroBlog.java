class MicroBlog {
    public String truncate(String input) {
        String result = "";
        if(input.codePointCount(0,input.length()-1) > 5){
            int index = Character.offsetByCodePoints(input,0,5);
            result = input.substring(0,index);
            return result;
        }else{
            return input;
        }
    }
}
