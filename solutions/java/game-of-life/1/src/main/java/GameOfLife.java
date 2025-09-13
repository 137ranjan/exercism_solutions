class GameOfLife {
    public int[][] tick(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] nextGenMatrix = new int[r][c];

        //int[][] neighborMatrix = {{0,1},{0,-1},{1,0},{-1,0}};  
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int liveNeighborCount = 0;
                int upNeighborI = i;
                int upNeighborJ = j+1;

                int downNeighborI = i;
                int downNeighborJ = j-1;

                int leftNeighborI = i-1;
                int leftNeighborJ = j;

                int rightNeighborI = i+1;
                int rightNeighborJ = j;

                int northEastI = i+1;
                int northEastJ = j-1;

                int southEastI = i+1;
                int southEastJ = j+1;

                int southWestI = i-1;
                int southWestJ = j-1;

                int northWestI = i-1;
                int notrhWestJ = j+1;

                if(upNeighborI >= 0 && upNeighborI <r 
                   && upNeighborJ >= 0 && upNeighborJ <c 
                   && matrix[upNeighborI][upNeighborJ] == 1){
                    liveNeighborCount++;
                }
                if(downNeighborI >= 0 && downNeighborI < r 
                   && downNeighborJ >= 0 && downNeighborJ <c 
                   && matrix[downNeighborI][downNeighborJ] == 1){
                    liveNeighborCount++;
                }
                if(leftNeighborI >= 0 && leftNeighborI < r 
                   && leftNeighborJ>= 0 && leftNeighborJ <c 
                   && matrix[leftNeighborI][leftNeighborJ] == 1){
                    liveNeighborCount++;
                }
                if(rightNeighborI >= 0 && rightNeighborI < r 
                   && rightNeighborJ >= 0 && rightNeighborJ <c 
                   && matrix[rightNeighborI][rightNeighborJ] == 1){
                    liveNeighborCount++;
                }
                if(northEastI >= 0 && northEastI < r 
                   && northEastJ >= 0 && northEastJ <c 
                   && matrix[northEastI][northEastJ] == 1){
                    liveNeighborCount++;
                }
                if(southEastI >= 0 && southEastI < r 
                   && southEastJ >= 0 && southEastJ <c 
                   && matrix[southEastI][southEastJ] == 1){
                    liveNeighborCount++;
                }
                if(southWestI >= 0 && southWestI < r 
                   && southWestJ >= 0 && southWestJ <c 
                   && matrix[southWestI][southWestJ] == 1){
                    liveNeighborCount++;
                }
                if(northWestI >= 0 && northWestI < r 
                   && notrhWestJ >= 0 && notrhWestJ <c 
                   && matrix[northWestI][notrhWestJ] == 1){
                    liveNeighborCount++;
                }
                System.out.println("i="+i+" j="+j+" liveNeighborCount="+liveNeighborCount);
                if(matrix[i][j] == 1 && (liveNeighborCount == 2 || liveNeighborCount == 3)){
                    nextGenMatrix[i][j] = 1;
                }
                if(matrix[i][j] == 0 && liveNeighborCount == 3){
                    nextGenMatrix[i][j] = 1;
                }
            }
        }
        return nextGenMatrix;
    }
}
