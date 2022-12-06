package Homework2;
import java.util.Scanner;
public class Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int size1 = input.nextInt();
            int size2 = input.nextInt();
            int size = Math.max(size1,size2);
            int[] arr1 = new int[size+1];
            int[] arr2 = new int[size+1];
            for (int j = 0; j <= size; j++){
                if (j <= size - size1){
                    arr1[j] = 0;
                }
                else{
                arr1[j] = input.nextInt();
                }
            }
            for (int k = 0; k <= size; k++){
                if (k <= size - size2){
                    arr2[k] = 0;
                }
                else{
                    arr2[k] = input.nextInt();
                }
            }
            //开始计算过程
            int[] arr3 = new int[size+1];
            for (int x = size; x >= 0; x--){
                if (arr1[x]+arr2[x]>=10){
                    arr3[x]=arr1[x]+arr2[x]-10;
                    arr1[x-1]++;
                }
                else{
                    arr3[x]=arr1[x]+arr2[x];
                }
            }
            if (arr3[0]==0){//双等号判定
                for (int l = 1; l <= size; l++){
                    System.out.print(arr3[l]);
                }
            }
            else{
                for (int l = 0; l <= size; l++){
                    System.out.print(arr3[l]);
                }
            }
            System.out.println();
        }
    }
}
