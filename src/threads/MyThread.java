package threads;

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Current thread name: "
                + Thread.currentThread().getName());
        System.out.println("run() method called");
    }
}

class GeeksforGeeks {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
