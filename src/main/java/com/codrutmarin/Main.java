package com.codrutmarin;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's backtrack");
        try{
            System.out.println("Here!");
            EightQueens eq = new EightQueens(3);
            eq.compute();
            System.out.println("Here!");
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
