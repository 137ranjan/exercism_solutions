import java.util.List;
import java.util.ArrayList;
class LuhnValidator {

    boolean isValid(String candidate) {
        if(candidate == null ){
            return false;
        }
        candidate = candidate.trim();
        if(candidate.length() < 2){
            return false;
        }

        for(int i=0; i<candidate.length(); i++){
            char ch = candidate.charAt(i);
            if(!Character.isDigit(ch) && ch != ' '){
                return false;
            }
        }

        String[] sections = candidate.split(" ");
        List<Integer> list = new ArrayList<>();
        for(String section : sections){
            for(char ch : section.toCharArray()){
                list.add(Character.getNumericValue(ch));
            }
        }

        for(int i=list.size() - 2; i >= 0; i-=2){
            int doubleNum = list.get(i)*2;
            if(doubleNum > 9){
                doubleNum -= 9;
            }
            list.set(i, doubleNum);
        }

        int sum = 0;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }
        if(sum % 10 == 0){
            return true;
        }
        return false;
    }

}
