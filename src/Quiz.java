public class Quiz {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        for(int x = 1; x < num.length-1; x++) {
            num[x] = num[0];
        }
        for(int i = 0 ;i<5;i++){
            System.out.printf("%d",num[i]);
        }
    }
}