class CollatzCalculator {

    int computeStepCount(int start) {
        if(start <= 0){
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        int steps = 0;
        int current = start;
        while(current != 1){
            if(current % 2 == 0){
                current /= 2;
            }else{
                current = current*3 + 1;
            }
            steps++;
        }
        return steps; 
    }

}
