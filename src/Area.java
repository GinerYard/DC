class CalculateArea{
    public static void main(String s[]) {
        int width = 20;
        int breadth = 30;
        int area = calculateArea(width,breadth);

        System.out.println("Area:"+area);
    }
    public static int calculateArea(int width,int breadth) {
        int area = width * breadth;
        return(area);
    }
}

