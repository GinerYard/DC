import java.util.Arrays;//定义数组
import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("How many numbers you will input:");
        int size = input.nextInt();
        int[] arr = new int[size];//int后面[]的个数是数组的维数，[size]是数组中包含数的数量
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = input.nextInt();//arr[i]是第i个数，但要注意从0开始
        }
        Arrays.sort(arr);//给数组从小到大排序
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
