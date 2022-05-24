package thread;

public class InfiniteThread {

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        MyThread1 myThread = new MyThread1();

        new Thread(myThread, "MyThread").start();

        try {
            Thread.sleep(1100);

            myThread.disable();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.println("Main thread finished...");
    }
}

class MyThread1 implements Runnable {

    private boolean isActive;

    void disable() {
        isActive = false;
    }

    public MyThread1() {
        this.isActive = true;
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1;

        while (isActive) {

            System.out.println("loop " + counter++);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }

        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

