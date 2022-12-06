package Homework5;

public class SilverCardMember extends Member{
    public SilverCardMember(String info) {
        super(info);
    }

    @Override
    public double consume(int amount) {
        return 0;
    }
}
