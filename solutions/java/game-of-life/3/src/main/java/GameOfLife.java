class GameOfLife {
    // 8 possible directions (row, col)
    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1},  // top-left, top, top-right
        {0, -1},           {0, 1},   // left,        right
        {1, -1}, {1, 0}, {1, 1}      // bottom-left, bottom, bottom-right
    };

    public int[][] tick(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int r = matrix.length;
        int c = matrix[0].length;
        int[][] nextGenMatrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int liveNeighborCount = 0;

                // Count live neighbors using direction vectors
                for (int[] dir : DIRECTIONS) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni >= 0 && ni < r && nj >= 0 && nj < c && matrix[ni][nj] == 1) {
                        liveNeighborCount++;
                    }
                }

                // Apply Game of Life rules
                if (matrix[i][j] == 1) {
                    nextGenMatrix[i][j] = (liveNeighborCount == 2 || liveNeighborCount == 3) ? 1 : 0;
                } else {
                    nextGenMatrix[i][j] = (liveNeighborCount == 3) ? 1 : 0;
                }
            }
        }
        return nextGenMatrix;
    }
}
