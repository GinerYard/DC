package Exer2;
import java.util.Scanner;

public class Exer21 {
    public static void main(String[] args) {
        float width;
        float height;
        float area;
        float perimeter;


        Scanner input = new Scanner(System.in);

        System.out.print("Enter the width of a rectangle:");
                width = input.nextFloat();
        System.out.print("Enter the height of a rectangle:");
                height = input.nextFloat();

                area = width * height;
                perimeter = 2 * (width + height);

        System.out.printf("The area is %.2f\nThe perimeter is %.2f",area,perimeter);



    }
}
