import java.util.Map;
import java.util.HashMap;

class RnaTranscription {

    private Map<Character, Character> complementMap;

    RnaTranscription(){
        complementMap = new HashMap<Character, Character>();
        complementMap.put('G','C');
        complementMap.put('C','G');
        complementMap.put('T','A');
        complementMap.put('A','U');
    }
    String transcribe(String dnaStrand) {
        if(dnaStrand == null || dnaStrand.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(char c: dnaStrand.toCharArray()){
            sb.append(complementMap.get(c));
        }
        return sb.toString();
    }

}
