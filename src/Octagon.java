import java.util.Scanner;

public class Octagon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if((i-j==2*(n-1)/3)||(j-i==2*(n-1)/3)||(i+j==5*(n-1)/3)||(i+j==(n-1)/3)||(i==0 && j>=(n-1)/3 && j <=2*(n-1)/3)||(j==0 && i>=(n-1)/3 && i <=2*(n-1)/3)||(i==n-1 && j>=(n-1)/3 && j <=2*(n-1)/3)||(j==n-1 && i>=(n-1)/3 && i <=2*(n-1)/3)){
                    a[i][j]=1;
                }
                else{
                    a[i][j]=0;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i==0){
                    if(j==0){
                    System.out.printf("%d",a[i][j]);
                    }
                    else{
                        System.out.printf(" %d",a[i][j]);
                    }
                }
                else{
                    if(j==0){
                        System.out.printf("\n%d",a[i][j]);
                    }
                    else{
                        System.out.printf(" %d",a[i][j]);
                    }
                }
            }
        }
    }
}
