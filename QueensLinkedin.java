class QueensLinkedin {
    public static void main(String[] args) {

        int[][] board = {
                { 0, 0, 2, 2, 2, 2, 2, 8, 8 },
                { 0, 0, 2, 7, 7, 7, 2, 8, 8 },
                { 0, 1, 1, 1, 7, 4, 4, 4, 8 },
                { 0, 0, 1, 3, 7, 7, 4, 6, 8 },
                { 0, 0, 1, 3, 3, 3, 4, 6, 6 },
                { 0, 0, 1, 5, 5, 3, 4, 6, 0 },
                { 0, 1, 1, 1, 5, 4, 4, 4, 0 },
                { 0, 0, 0, 0, 5, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        solveQueens(board);
    }

    public static void solveQueens(int[][] board) {
        int vis[] = new int[9];
        solve(board, 0, vis);
        printBoard(board);
    }

    public static boolean solve(int[][] board, int r, int[] vis) {
        if (r == 9)
            return true;
        for (int i = 0; i < 9; i++) {
            if (isSafe(board, r, i, vis)) {
                int col = board[r][i];
                board[r][i] = -1;
                vis[col] = 1;
                if (solve(board, r + 1, vis))
                    return true;
                board[r][i] = col;
                vis[col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int r, int c, int[] vis) {
        if (vis[board[r][c]] == 1)
            return false;
        int i = r;
        while (i >= 0) {
            if (board[i][c] == -1)
                return false;
            i--;
        }
        i = c;
        while (i >= 0) {
            if (board[r][i] == -1)
                return false;
            i--;
        }
        if (r - 1 >= 0 && c - 1 >= 0 && board[r - 1][c - 1] == -1)
            return false;
        if (r - 1 >= 0 && c + 1 < 9 && board[r - 1][c + 1] == -1)
            return false;
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == -1)
                    System.out.print("Q" + " ");
                else
                    System.out.print("X" + " ");
            }
            System.out.println();
        }
    }
}