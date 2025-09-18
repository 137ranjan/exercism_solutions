import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {

    private Map<Character, Integer> validNucleotides;

    NucleotideCounter(String sequence) {
        validNucleotides = new HashMap<>();
        validNucleotides.put('A', 0);
        validNucleotides.put('C', 0);
        validNucleotides.put('G', 0);
        validNucleotides.put('T', 0);
        for (char letter : sequence.toCharArray()) {
            if (validNucleotides.containsKey(letter)) {
                validNucleotides.put(letter, validNucleotides.get(letter) + 1);
            } else {
                throw new IllegalArgumentException("Invalid nucleotide in strand");
            }
        }
    }

    Map<Character, Integer> nucleotideCounts() {
        return validNucleotides;
    }

}