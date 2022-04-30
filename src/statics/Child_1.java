package statics;

public class Child_1 extends Parent {

    public static int counter = 0;

    public Child_1() {
        super();
        ++Child_1.counter;
    }

    public static void testOverride(){
        System.out.println("CHILD");
    }

}
