package com.codrutmarin;

/**
 *  This is the backtracking class it will be used to compute the max number of queens on a board of n x n
 */
public class EightQueens {
    private int[] stack; // It is important that the problem starts small and slowly gains some weight, so first a stack will be used to compute all possible permutation of the following sequence {1..n}
    private int n; // stack size
    private int current = 0; // current index, will be used to easily compute a value in the stack

    /**
     * @param n the stack size
     */
    public EightQueens(int n) throws Exception
    {
        if(n <= 1 || n > 9)
        {
            throw new Exception("Invalid stack size, stack size `n` needs to be grater than 1 and smaller or equal with 9");
        }else {
            this.n = n;
            stack = new int[n];
        }
    }

    /**
     * Helper function when increasing the current position the stack value at position current will become 0
     */
    private void init()
    {
        stack[current] = 0;
    }

    /**
     * Helper function when computing the current value in the stack, it needs to be known when the current value will be valid
     * Due to the permutation requirement this means that the current value needs to be different from the already calculated values
     * @return boolean
     */
    private boolean isValid()
    {
        for(int i = 0; i < current; i++)
        {
            if ( stack[current] == stack[i])
            {
                return false;
            }
        }
        return true;
    }

    /**
     *  Helper function when a solution has been completely computed, this function will output it
     */
    private void printSolution()
    {
        for(int item : stack)
        {
            System.out.print(item);
        }
        System.out.println("");
    }

    /**
     * The main function making use of recursion to compute all permutations for {1..n} sequence
     */
    private void backtrack()
    {
        if ( current >= 0) // <= stopping condition
        {
            if (stack[current] < n) // checking if there are still values we can use in the given sequence
            {
                stack[current]++;
                if(isValid()) // checking if the current value is valid
                {
                    current++;
                    if(current == n) // checking if the end of the stack has been reached
                    {
                        printSolution();
                        current--;
                    }else{
                        init();
                    }
                }
            }else {
                current--;
            }
            backtrack();
        }
    }

    public void compute()
    {
        backtrack();
    }
}
