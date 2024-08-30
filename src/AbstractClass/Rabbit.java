package AbstractClass;

public class Rabbit extends Animal {

    @Override// you should override the abstract method from the parent class
    void a() {
        System.out.println("Rabbit hopping");
    }

    public void func() {
        super.func();
        System.out.println("Rabbit running");
    }

    public static void main(String[] args) {
//        Animal animal = new Animal(); Abstract classes cannot be instantiated

        Rabbit rabbit = new Rabbit();
        rabbit.func();
        rabbit.a();
    }
}
