package Homework1;
import java.util.Scanner;
public class Problem4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int count = input.nextInt();
        int i = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        while(i <= count) {
            int s = input.nextInt();
            if(90<=s&&s<=100){
                a++;
            }
            if(80<=s&&s<90){
                b++;
            }
            if(70<=s&&s<80){
                c++;
            }
            if(60<=s&&s<70){
                d++;
            }
            i++;
        }
        System.out.printf("A: %d\nB: %d\nC: %d\nD: %d",a,b,c,d);
    }
}
