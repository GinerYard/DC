package Exer2;
import java.util.Scanner;

public class Exer23 {
    public static void main(String[] args) {
        int score;
        float GPA=0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your score:");
                score = input.nextInt();

                if (60 <= score && score <= 100) {
                    System.out.println("You passed the exam.");
                }
                else{
                    System.out.println("You failed in the exam");
                }

                if (90 <= score && score <= 100){
                    GPA = 4;
                }
                if (80 <= score && score <= 89){
                    GPA = 3;
                }
                if (70 <= score && score <= 79){
                    GPA = 2;
                }
                if (60 <= score && score <= 69){
                    GPA = 1;
                }
                if (0 <= score && score <= 59){
                    GPA = 0;
                }

        System.out.printf("You score is %d.0, the GPA is %.1f\n",score,GPA);
        while(score != 0)
        {
            System.out.print("Enter your score:");
            score = input.nextInt();

            if (60 <= score && score <= 100) {
                System.out.println("You passed the exam.");
            }
            else{
                System.out.println("You failed in the exam");
            }

            if (90 <= score && score <= 100){
                GPA = 4;
            }
            if (80 <= score && score <= 89){
                GPA = 3;
            }
            if (70 <= score && score <= 79){
                GPA = 2;
            }
            if (60 <= score && score <= 69){
                GPA = 1;
            }
            if (0 <= score && score <= 59){
                GPA = 0;
            }
            System.out.printf("You score is %d.0, the GPA is %.1f\n",score,GPA);
        }

    }
}
