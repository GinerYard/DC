
package Homework1;
import java.util.Scanner;
public class Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int i = 1;
        System.out.print("");
        while(i <= count){
            System.out.print("");
            int month = input.nextInt();
            if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12){
                System.out.print("yes\n");
            }
            else{
                System.out.print("no\n");
            }
            i++;
        }
    }
}
