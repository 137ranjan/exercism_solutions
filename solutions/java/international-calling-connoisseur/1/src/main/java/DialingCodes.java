import java.util.Map;
import java.util.HashMap;

public class DialingCodes {

    private Map<Integer, String> dialingCodeCountryMap;

    public DialingCodes(){
        dialingCodeCountryMap = new HashMap<>();
    }
    
    public Map<Integer, String> getCodes() {
        return dialingCodeCountryMap;
    }

    public void setDialingCode(Integer code, String country) {
        dialingCodeCountryMap.put(code, country);
    }

    public String getCountry(Integer code) {
        return dialingCodeCountryMap.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if(!dialingCodeCountryMap.containsKey(code)){
            for(String existingCountry : dialingCodeCountryMap.values()){
                if(existingCountry.equals(country)){
                    return;
                }
            }
            dialingCodeCountryMap.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        for(Map.Entry<Integer, String> entry : dialingCodeCountryMap.entrySet()){
                if(entry.getValue().equals(country)){
                    return entry.getKey();
                }
            }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        for(Map.Entry<Integer, String> entry : dialingCodeCountryMap.entrySet()){
            if(entry.getValue().equals(country)){
                dialingCodeCountryMap.remove(entry.getKey());
                dialingCodeCountryMap.put(code, country);
            }
        }
    }
}
