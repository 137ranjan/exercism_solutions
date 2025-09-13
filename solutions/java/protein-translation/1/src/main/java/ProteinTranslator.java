import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class ProteinTranslator {

    private Map<String, String> codonAminoAcidMap;

    public ProteinTranslator(){
        codonAminoAcidMap = new HashMap<>();
        codonAminoAcidMap.put("AUG", "Methionine");
        codonAminoAcidMap.put("UUU", "Phenylalanine");
        codonAminoAcidMap.put("UUC", "Phenylalanine");
        codonAminoAcidMap.put("UUA", "Leucine");
        codonAminoAcidMap.put("UUG", "Leucine");
        codonAminoAcidMap.put("UCU", "Serine");
        codonAminoAcidMap.put("UCC", "Serine");
        codonAminoAcidMap.put("UCA", "Serine");
        codonAminoAcidMap.put("UCG", "Serine");
        codonAminoAcidMap.put("UAU", "Tyrosine");
        codonAminoAcidMap.put("UAC", "Tyrosine");
        codonAminoAcidMap.put("UGU", "Cysteine");
        codonAminoAcidMap.put("UGC", "Cysteine");
        codonAminoAcidMap.put("UGG", "Tryptophan");
        codonAminoAcidMap.put("UAA", "STOP");
        codonAminoAcidMap.put("UAG", "STOP");
        codonAminoAcidMap.put("UGA", "STOP");
    }
    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<rnaSequence.length(); i+=3){
            if( (i+3) > rnaSequence.length()){
                throw new IllegalArgumentException("Invalid codon");
            }
            String codon = rnaSequence.substring(i, i+3);
            String aminoAcid = codonAminoAcidMap.get(codon);
            if(aminoAcid == null){
                throw new IllegalArgumentException("Invalid codon");
            }
            if(aminoAcid.equals("STOP")){
                return result;
            }else{
                result.add(aminoAcid);
            }
            
        }
        
        return result;
    }
}
