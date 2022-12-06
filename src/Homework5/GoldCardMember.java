package Homework5;

public class GoldCardMember extends Member {


    public GoldCardMember(String info) {
        super(info);
    }

    @Override
    public double consume(int amount) {
        return 0;
    }
}
