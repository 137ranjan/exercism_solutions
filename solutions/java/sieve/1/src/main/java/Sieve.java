import java.util.ArrayList;
import java.util.List;

class Sieve {
	private final int[] arr;
    Sieve(int maxPrime) {
        arr = new int[maxPrime + 1];
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i < arr.length; i++){
            if(arr[i] == 0){
                for(int j=i+i; j < arr.length; j+= i){
                    arr[j]++;
                }
            }
        }

        for(int i=2; i < arr.length; i++){
            if(arr[i] == 0){
                primes.add(i);
            }
        }
        return primes;
    }
}
