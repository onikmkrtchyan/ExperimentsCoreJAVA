package statics;

public class Child_2 extends Child_1 {

    public static int counter = 0;

    public Child_2() {
        super();
        ++Parent.counter;//1
        ++Child_2.counter;//1
    }
}
