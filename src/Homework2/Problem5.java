package Homework2;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++){
            String Str = input.next();
            System.out.printf(Str.substring(6,8));
            System.out.printf(Str.substring(4,6));
            System.out.printf(Str.substring(2,4));
            System.out.printf(Str.substring(0,2));
            System.out.printf(" ");
        }
        System.out.printf("\b");//退格符
    }
}
