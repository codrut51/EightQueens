package com.codrutmarin;

/**
 * This is the backtracking class it will be used to compute the max number of queens on a board of n x n
 */
public class EightQueens {
    private int[][] board; // It is important that the problem starts small and slowly gains some weight, so first a stack will be used to compute all possible permutation of the following sequence {1..n}
    private int n; // stack size
    private int row = 0; // current row, will be used to easily compute a value in the board
    private int col = 0; // current col, will be used to easily get the position of a queen in a row
    private int count = 0; // increased to calculate the number of solutions computed

    /**
     * Making sure that the current board is a valid input
     *
     * @param n the stack size
     */
    public EightQueens(int n) throws Exception {
        if (n < 4) {
            throw new Exception("Invalid stack size, stack size `n` needs to be grater than 3");
        } else {
            this.n = n;
            board = new int[n][n];
        }
    }

    /**
     * helper function ensures that the current row will have no queens placed
     */
    private void init() {
        for (int i = 0; i < n; i++) {
            board[row][i] = 0;
        }
    }

    /**
     * @return true if current position is a valid position
     */
    private boolean isValid() {
        int condition = Math.max(row, col); // calculating the current max so it is not exceeded
        for (int i = 0; i < condition; i++) // doing this in one loop greatly improves performance of the validation
        {
            int col1 = i - (row - col); // left diagonal based on the current position of the queen
            int col2 = ((n - 1) - i) + (col - ((n - 1) - row)); // right diagonal based on the current position of the queen
            if ((board[row][i] == 1) ||
                    (board[i][col] == 1) ||
                    (col1 >= 0 && col1 < n && board[i][col1] == 1) ||
                    (col2 >= 0 && col2 < n && board[i][col2] == 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * s
     *
     * @return the current position of a queen in a row or -1 if not found
     */
    private int whereIsCurrent() {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Helper function placing the queen on the current row on a next valid position
     */
    private void next() {

        col = whereIsCurrent() == -1 ? 0 : whereIsCurrent(); // making sure that the current position exists and it is not out the boundaries

        if (whereIsCurrent() != -1) {
            col++; // incrementing the current position so the next
            board[row][col - 1] = 0; // ensuring the previous position is removed to be properly validated
        }
        boolean valid = false; // assuming the current position is not valid
        if (col < n) // making sure that the current position can be incremented
        {
            do {
                valid = isValid();
                if (!valid) // saving the current position when is valid
                {
                    col++;
                }
            } while (col < n && !valid); // exiting when col exceeds boundaries
        }

        if (!valid && col == n) // making sure that there are a queen is placed on no position when the outcome is not valid
        {
            board[row][col - 1] = 0;
        } else if (valid) {
            board[row][col] = 1; // ensuring there is a queen placed when the outcome is valid
        }

    }

    /**
     * Outputs the current solution on the screen
     */
    private void printSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    /**
     * "Main" function making use of recursion to calculate all possible solutions
     */
    private void backtrack() {
        if (row >= 0) {
            next();
            if (col < n) {
                row++;
                col = 0;
                if (row < n) {
                    init();
                } else {
                    printSolution();
                    System.out.println();
                    System.out.println();
                    count++;
                    row--;
                }
            } else {
                if (board[row][col - 1] == 0) // when the current row has no queens placed on it (it is already known that it is not a valid solution
                {
                    row--;
                }
                col = 0;
            }
            backtrack();
        } else {
            System.out.println("Maximum number of arrangements is: " + count);
        }
    }

    /**
     * Function used to start the backtracking process
     */
    public void compute() {
        backtrack();
    }
}
