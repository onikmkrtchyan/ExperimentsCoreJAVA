public class Main0{
    public static void main(String[] args) {
        Child2 child = new Child2();
//        child.getHeight();
        new Parent2().getHeight();
    }

}

//Static or Final methods can't Override
class Parent2{
    static protected int num = 7;
   /*static*/ void getHeight(){
        System.out.println("Height is 180 sm");
    }

}

abstract class Child0 extends Parent2{

    void f(){
        num = 10;
    }

    void getHeight(){
        System.out.println("Height is 130 sm");
    }
}

abstract class AbstractClass{
    abstract void func();
}

class Child2 extends AbstractClass{
    @Override
    void func() {
        //IMPL
    }
}

interface Child3 {
    void f();

}

interface Child7{

}

abstract class Child4 implements Child3{
    @Override
    public void f() {
        System.out.println("Abs implement ch4");
    }
}

class multiInherit extends Child4 implements Child3,Child7{

}