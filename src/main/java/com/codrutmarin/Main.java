package com.codrutmarin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's backtrack");
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Input a number n => {2..9}: ");
            int n = scan.nextInt();
            EightQueens eq = new EightQueens(n);
            eq.compute();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
