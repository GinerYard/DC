import java.util.Scanner;
class MyTriangle {
    public static double area(double bottom, double height) {//定义函数，括号内是变量
        return 0.5 * bottom * height;//输出函数值，也可先写出area与变量的关系再return(area);
    }
    public static double area(double a, double b, int angleOfAandB){
        return 0.5 * a * b * Math.sin(angleOfAandB * Math.PI / 180);//转换为弧度制
    }

}
public class Lab6E2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input two numbers for bottom and height:");
        double bottom = input.nextDouble();//变量的定义只适用于限制范围本身
        double height = input.nextDouble();
        double y = MyTriangle.area(bottom,height);//表示引用了在MyTriangle class中的area函数
        System.out.printf("The area is %.3f\n",y);
        System.out.println("Please input two numbers for a and b:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        System.out.println("Please input a number in (0, 180) for angle (angle is a float variable):");
        int angleOfAandB = input.nextInt();
        double z = MyTriangle.area(a,b,angleOfAandB);
        System.out.printf("The area is %.3f\n",z);
    }
}

