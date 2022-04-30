package statics;

public class Parent {

    public static int counter = 0;

    public Parent() {
        ++Parent.counter;
        ++Child_1.counter;
    }


    public static void testOverride() {
        System.out.println("PARENT");
    }

    public void testOverride1() {
        System.out.println("PARENT1");
    }
}
