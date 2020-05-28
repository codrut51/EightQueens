package com.codrutmarin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's backtrack");
        Scanner scan = new Scanner(System.in);
        System.out.println("Input a number n ( n >= 4): ");
        int n = scan.nextInt();
        do{
            if(n == 0)
            {
                try {
                    EightQueens eq = new EightQueens(n);
                    eq.compute();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Input a number n ( n >= 4): ");
                n = scan.nextInt();
        }

        }while (n != 0);

    }

}