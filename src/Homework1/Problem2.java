package Homework1;
import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int i = 1;
        System.out.print("");
        while(i <= count) {
            double x1 = input.nextDouble();
            double y1 = input.nextDouble();
            double x2 = input.nextDouble();
            double y2 = input.nextDouble();
            double x = input.nextDouble();
            double a = (y2 - y1) / (x2 - x1);
            double b = y1 - a * x1;
            double y = a * x + b;
            System.out.printf("%.1f\n",y);
            i++;
        }
    }

}
