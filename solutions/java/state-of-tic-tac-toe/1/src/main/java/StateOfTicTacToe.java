class StateOfTicTacToe {
    public GameState determineState(String[] board) {
        char[][] grid = new char[3][3];
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                if (ch == 'X')
                    xCount++;
                else if (ch == 'O')
                    oCount++;

                grid[i][j] = ch;
            }
        }

        if (oCount > xCount) {
            throw new IllegalArgumentException("Wrong turn order: O started");
        }

        if (xCount > oCount + 1) {
            throw new IllegalArgumentException("Wrong turn order: X went twice");
        }

        boolean xWins = hasWon(grid, 'X');
        boolean oWins = hasWon(grid, 'O');

        // Both cannot win or playing after win
        if (xWins && oWins) {
            throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
        }

        if (oWins && xCount != oCount) {
            throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
        }

        if (xWins || oWins) {
            return GameState.WIN;
        }

        // Check empty spaces
        boolean hasEmpty = false;
        for (char[] row : grid) {
            for (char ch : row) {
                if (ch == ' ') {
                    hasEmpty = true;
                    break;
                }
            }
        }
        return hasEmpty ? GameState.ONGOING : GameState.DRAW;
    }

    private boolean hasWon(char[][] g, char p) {
        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if ((g[i][0] == p && g[i][1] == p && g[i][2] == p)
                    || g[0][i] == p && g[1][i] == p && g[2][i] == p) {
                return true;
            }
        }

        // Diagonals
        return (g[0][0] == p && g[1][1] == p && g[2][2] == p)
                || (g[0][2] == p && g[1][1] == p && g[2][0] == p);
    }
}
