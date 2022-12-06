import java.util.Scanner;
public class Time {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do{
            System.out.println("Please input a number to print the Multiplication Table [0 to terminate]:");
            n = input.nextInt();
            if (n == 0){
                break;
            }
            if (n<1|n>9){
                System.out.println("Please input a number between [1,9]");
            }
            else{
                int i = 1;
                int j = 1;
                for(i=1;i<=n;i++){
                    for(j=1;j<=i;j++){
                        System.out.print(i+"*"+j+"="+i*j+"\t");
                    }
                    System.out.println();
                }
            }
        } while (true);

    }
}
