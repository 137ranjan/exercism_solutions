import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if(square < 1 || square > 64){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        BigInteger TWO = new BigInteger("2");
        return TWO.pow(square-1);
    }

    BigInteger grainsOnBoard() {
        BigInteger TWO = new BigInteger("2");
        BigInteger sum = new BigInteger("0");
        for(int i=0; i<64; i++){
            sum = sum.add(TWO.pow(i));
        }
        return sum;
    }

}
