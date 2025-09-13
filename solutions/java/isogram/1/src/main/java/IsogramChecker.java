import java.util.Set;
import java.util.HashSet;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        String cleanedPhrase = phrase.replaceAll("[\\s-]","").toLowerCase();
        Set<Character> seenLetters = new HashSet<>();

        for(char c : cleanedPhrase.toCharArray()){
            if(seenLetters.contains(c)){
                return false;
            }
            seenLetters.add(c);
        }
        return true;
    }

}
