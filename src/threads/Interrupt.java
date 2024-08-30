package threads;

//We can interrupt a thread, but that thread also needs to handle the interrupt and treat it in some way
//In the following example, main thread spins a new thread.
//How to terminate that thread?
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable job1 = () -> {
            int i = 1;
            while (true) {
                if (Thread.interrupted()) {
                    // End the loop when interrupted
                    break;
                }
                System.out.println("Doing something " + i);
                i++;
            }
        };

        Thread t1 = new Thread(job1);
        t1.start();
        Thread.sleep(100);
        t1.interrupt();        // Interrupt the thread t1 after 3 seconds
        System.out.println("Rest of main thread...");
    }

}
//Interrupting is not same as stopping a thread, since the interrupted thread's running code decides what to do with that interrupt signal

//Thread.sleep(long millis) causes the current thread to go to sleeping mode. It simulates a long-running task, however without consuming CPU time.
//All monitors are retained by the current thread
//While in sleeping mode, the thread can also be interrupted but since the thread is not in running mode, that will raise an InterruptedException and the thread will be running again
//This is similar to the previous example but consuming less resources.
class InterruptSleeping {
    public static void main(String[] args) throws InterruptedException {
        Runnable job1 = () -> {
            int i = 1;
            while (true) {
                try {
                    System.out.println("Doing something " + i);
                    i++;
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted. Quitting. " + e);
                    break;
                }
            }
        };

        Thread t1 = new Thread(job1);
        t1.start();
        Thread.sleep(300);
//        t1.interrupt();
        System.out.println("Rest of main thread...");
    }
}
