package Homework2;
import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int i = 1;
        int k = 0;
            while (i <= n && k == 0) {
                int a = 0;
                for (int j = 0; j < n; j++) {
                    if (i == arr[j]) {
                        a++;
                    }
                }
                if (a == 0) {
                    System.out.print(i);
                    k++;
                }
                i++;
            }
            int x = i;
            if (i <= n){
                while (x <= n) {
                    int a = 0;
                    for (int j = 0; j < n; j++) {
                        if (x == arr[j]) {
                            a++;
                        }
                    }
                    if (a == 0) {
                        System.out.print(" "+x);
                    }
                    x++;
                }
            }
            if (i == n+1){
                System.out.print("NULL");
            }
    }
}

