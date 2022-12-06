package Homework2;
import java.util.Arrays;
import java.util.Scanner;
public class Problem4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr2 = new int[5];
        String[] arr1 = new String[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = input.next();
            arr2[i] = input.nextInt();
            //数组1是花色，数组2是数字

        }
        input.close();
        Arrays.sort(arr2);
        int[] arr = new int[4];
        for (int j = 0; j < 4; j++) {
            arr[j] = arr2[j + 1] - arr2[j];
        }
        //将数组2从小到大排序并生成辅助差数组
        if ((arr1[1].equals(arr1[2]))&&(arr1[0].equals(arr1[1]))&&(arr1[2].equals(arr1[3]))&&(arr1[3].equals(arr1[4])))
        {

                       if ((arr[1] == 1 && arr[2] == 1) && arr[3] == 1 && arr[0] == 1)
                        {//四个差都是1（顺子）
                            System.out.print("Straight Flush");
                        }
                        else
                        {
                            System.out.print("Flush");
                        }

        }
        else {
            if ((arr[1] == 1 && arr[2] == 1) && arr[3] == 1 && arr[0] == 1) {
                System.out.print("Straight");
                return;
            }
            if ((arr[0] == 0 && arr[1] == 0) || (arr[1] == 0 && arr[2] == 0) || (arr[2] == 0 && arr[3] == 0)) {//三条（三张相同）
                System.out.print("Three of a Kind");
                return;
            }
            if ((arr[0] == 0 && arr[1]!=0 )|| (arr[0] != 0 && arr[1] == 0 && arr[2] !=0)|| (arr[1]!=0 && arr[2]==0 && arr[3] != 0 )|| (arr[2] != 0 && arr[3]==0)) {//对子（两张相同）
                System.out.print("Pair");
            }
            else {
                System.out.print("High Card");
            }
        }
    }
}