import java.util.Scanner;

public class Integers {
    public static void main(String[] args) {

        Integer a = 1;
        int c = 1;

        Scanner scanner = new Scanner(System.in);
        Integer b = scanner.nextInt();

        System.out.println(a == b);
        System.out.println(a==c);
    }
}
