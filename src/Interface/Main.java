package Interface;

public class Main {
    private final MainInterface mainInterface;

    public Main(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
        mainInterface.something();
    }

    public static void main(String[] args) {
          new Main(new Child_1()).call();
          new Main(new Child_2()).call();
          new Main(new Child_3()).call();

        System.out.println("----------------------------------------");

          MainInterface mainInterface = new Child_3();
          mainInterface.print();

          mainInterface = new Child_2();
          mainInterface.print();

          mainInterface = new Child_1();
          mainInterface.print();

        System.out.println("----------------------------------------");

        meta(new Child_2());
        meta(new Child_1());
        meta(new Child_3());
    }

    private static void meta(MainInterface mainInterface){
        mainInterface.print();
    }

    private void call(){
        mainInterface.print();
    }
}