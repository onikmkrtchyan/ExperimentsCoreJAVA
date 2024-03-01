public class Main3{

    public static void main(String []args){
        System.out.println(Mistake.class);
//        Mistake mistake = new Mistake();
//        mistake.printField();
    }
}

class Mistake {

        static Mistake mistake = new Mistake(10);
        static int exp;

    public int someField;
//
//    public Mistake() {
//        someField = 0;
//    }
//
    public Mistake(int param) {
        System.out.println("Yes");
        someField = param * exp;
    }

//    public void printField() {
//        System.out.println(mistake.someField);
//    }
}
