package Homework5;


public abstract class Member {
    private String memberId; //Every member have an id and the id is unique for each member
    private char gender; //Gender can only be 'F' or 'M'
    private int age; //Age can only be a positive integer

    public Member(String info) {
    }

    public abstract double consume(int amount);

    public double getTotalCost() {
        return 0;
    }

    public String getGenderAgeCost() {
        return null;
    }

    public String toString() {
        return null;
    }

}
