import java.util.Scanner;

class User {
    private String account;
    private String password;
    private double money;//定义这些量并声明将它们私有化


    public void setMoney(double money){//使用了驼峰命名法
        this.money=money;//this表示引用的是整个Class中定义的那个变量，未加修饰则默认引用最小定义域的那个定义出来的变量，即：等号后面的money是等号前面那个money进行public化的值
    }
    public double getMoney(){
        return money;
    }//set是设置一个变量，get是获取一个变量
    //这里的操作是因为，private定义的变量无法直接在Class外（比如这个案例中的UserTest）调用，需要用一个public的函数获取


    public void setUser(String account){
        this.account = account;
    }
    public String getUser(){
        return account;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }


    public void introduce(){//没有要求任何返回值(return或函数运算)时用void
        System.out.printf(account);
    }
    public void expense(double value, Scanner in){//Scanner是对in的声明，在这里跟double等具有相同效果，这里的定义调用了第49行的声明
        String s = in.next();
        if(s.equals(password) && money>=value){
            money = money - value;
        }
    }
    public void income(double value){
        money = money + value;
    }
}
public class UserTest{
    public static void main(String[] args) {
        User user =new User();
        Scanner in = new Scanner(System.in);
        user.setUser("Lucy");
        user.setPassword("123456");
        user.setMoney(1000);
        user.introduce();
        user.expense(2000,in);
        user.expense(500,in);
        user.income(1000);
        user.introduce();
        in.close();
        System.out.printf("\n%s,%f",user.getUser(),user.getMoney());//不是纯粹的int之类的话，必须要用调用函数的形式
    }
}
//这个算法是存取款的标准算法
