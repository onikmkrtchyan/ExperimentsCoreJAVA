public class StringVsStringBuilder {
    public static void main(String[] args) {
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = one.append("asdasd");// three = one and then appends

        System.out.println(one == two);
        System.out.println(one == three);

        String x = "Hello World";
        String y = "Hello World";
        String z = "Hello World ".trim();

        System.out.println(x == y);
        System.out.println(x == z);
        System.out.println(x.equals(z));
    }
}
