import java.util.Scanner;

public class StringPool {
    public static void main(String[] args) {

        String a1 = "string";
        String a9 = " string";
        String h = a1.substring(0);
        String b1 = a9.substring(1);
        System.out.println(a1 == b1);
        String a2 = new String("string");
        String a6 = a2.intern();
        String a5 = new String("string");
        System.out.println(a6 == a2 + "------------YOU WON------------");
        String a3 = "string";
        a3.intern();
        System.out.println(a1 == a2);
        System.out.println(a1 == a3);


        Scanner s = new Scanner(System.in);
        String s4 = s.nextLine();
        System.out.println(a1 == s4);

          StringBuilder stringBuilder = new StringBuilder("asd");
            System.out.println(stringBuilder);
            f(stringBuilder);
            System.out.println(stringBuilder);
    }

    public static void f(StringBuilder a){
//        a = new StringBuilder("dsfsdfsdf");
        a.append("dsad");
    }
}
