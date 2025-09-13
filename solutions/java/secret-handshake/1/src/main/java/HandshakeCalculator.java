import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> signalList = new ArrayList<Signal>();
        String binaryNum = Integer.toBinaryString(number);
        int i = binaryNum.length() - 1;
        if(binaryNum.charAt(i) == '1'){
            signalList.add(Signal.WINK);
        }
        if(((i-1) >= 0) && binaryNum.charAt(i - 1) == '1'){
            signalList.add(Signal.DOUBLE_BLINK);
        }
        if(((i-2) >= 0) && binaryNum.charAt(i - 2) == '1'){
            signalList.add(Signal.CLOSE_YOUR_EYES);
        }
        if(((i-3) >= 0) && binaryNum.charAt(i - 3) == '1'){
            signalList.add(Signal.JUMP);
        }
        if(((i-4) >= 0) && binaryNum.charAt(i - 4) == '1'){
            Collections.reverse(signalList);
        }
        return signalList;
    }

}
