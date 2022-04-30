
public class StaticAndNotStaticDiff {

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();
        Counter c5 = new NewCounter();//This too increments
        System.out.println(Counter.COUNT);
        System.out.println(Counter.COUNT);
        System.out.println(Counter.COUNT);
        System.out.println(c3.num);
        System.out.println(c4.num);
        System.out.println(Counter.COUNT);
    }

}

class Counter {
    public static int COUNT = 0;
    public int num;
    Counter() {
        COUNT++;
        num++;
    }
}

class NewCounter extends Counter{}