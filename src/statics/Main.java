package statics;

public class Main {
    //in byte code this block moves to constructor
    {
        System.out.println(true);
    }

    static {
        System.out.println(false);
    }

    public static void main(String[] args) {
        new Parent().testOverride();
        new Child_1().testOverride();

        new Child_2();
        new Child_1();
        System.out.println(Parent.counter);//1 + 1 + 1       = 3
        System.out.println(Child_1.counter);//1 + 1 + 1 + 1  = 4
        System.out.println(Child_2.counter);//1              = 1
    }
}
