import java.util.Scanner;
public class While {

    public static void main(String[] args) {
        int grade;
        int gradeCounter;
        int total;
        double average;

        Scanner input = new Scanner(System.in);
        total=0;
        gradeCounter=1;
        while(gradeCounter <= 10){
            System.out.print("Enter your grade:");
            grade = input.nextInt();
            total += grade;
            gradeCounter +=1; //这里表示gradeCounter = gradeCounter + 1，也可写成gradeCounter++或++gradeCounter;
        } //b=a++ 即b=a,a=a+1;b=++a 即a=a+1,b=a;
        average = total / 10;
        System.out.printf("\nTotal of all 10 grades is %d\n,Class average is %.1f",total,average);//一个souf只能有一个%d;
        input. close();



    }

}

