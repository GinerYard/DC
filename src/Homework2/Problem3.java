package Homework2;
import java.util.Arrays;
import java.util.Scanner;
public class Problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr1 = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < 4; i1++){
            arr1[i1] = input.nextInt();
            }
            for (int i2 = 0; i2 < 4; i2++) {
                arr2[i2] = input.nextInt();
            }
            if (arr1[0] + arr1[1] + arr1[2] + arr1[3] >= 100) {
                System.out.println("0");
            } else {
                int[] arr = new int[120 - arr1[0] - arr1[2] - arr1[3] - arr1[1]];
                int j = 0;
                while (j < arr.length) {
                    for (int x = 0; x < 4; x++) {
                        for (int k = 0; k < 30 - arr1[x]; k++) {
                            arr[j] = arr2[x];
                            j++;
                        }
                    }
                }
                Arrays.sort(arr);
                int sum = arr1[1] + arr1[2] + arr1[3] + arr1[0];
                int day = 0;
                int a = 0;
                while (sum < 100) {
                    sum++;
                    day = day + arr[a];
                    a++;
                }
                System.out.println(day);
            }
        }
    }
}