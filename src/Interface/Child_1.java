package Interface;

public class Child_1 implements MainInterface, AnotherInterface{

    @Override
    public void print() {
        System.out.println("CHILD_1");
    }

    @Override
    public int something() {
        return MainInterface.super.something();
    }
}