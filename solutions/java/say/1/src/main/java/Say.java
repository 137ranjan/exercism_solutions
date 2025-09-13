import java.util.List;
import java.util.ArrayList;

public class Say {
    private static final String[] UNITS = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
        "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    private static final String[] THOUSANDS = {
        "", "thousand", "million", "billion", "trillion"
    };
    public String say(long number) {
        if(number < 0 || number > 999999999999L){
            throw new IllegalArgumentException();
        }
        if(number == 0){
            return "zero";
        }
        List<Long> chunks = new ArrayList<>();
        long current = number;
        while(current > 0){
            chunks.add(current % 1000);
            current /= 1000;
        }
        StringBuilder result = new StringBuilder();
        for(int i = chunks.size() - 1; i >= 0; i--){
            if(chunks.get(i) != 0){
                result.append(sayChunk(chunks.get(i)))
                    .append(" ")
                    .append(THOUSANDS[i])
                    .append(" ");
            }
        }
        return result.toString().trim();
    }

    public String sayChunk(long number){
        if(number == 0){
            return "";
        }
        if(number < 20){
            return UNITS[(int)number];
        }
        if(number < 100){
            return TENS[(int)number/10] + ((number % 10 != 0)? "-" + UNITS[(int) number % 10] : ""); 
        }
        return UNITS[(int) number/100] 
            + " hundred"+ ((number % 100 != 0)? " " + sayChunk(number % 100): "");
    }
}
