import java.util.Scanner;
public class If {
    public static void main(String[] args){
    Scanner input=new Scanner(System.in);
        int count = input.nextInt();
        int j = 1;
        while(j <= count) {
            int y = input.nextInt();
            if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                System.out.println("Yes");
                int i = 0;
                int a = y + 1;
                while (a < 2000) {
                    if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
                        i++;
                    }
                    a++;
                }
                int x1 = 1999 - y - i;
                int x2 = 1999 - y - x1;
                int x = 366 - 60 + 365 * x1 + 366 * x2 + 1;
                System.out.printf("%d\n", x);
            } else {
                System.out.print("No\n");
            }
            j++;
        }
}
}
