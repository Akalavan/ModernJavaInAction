package thread;

public class InfiniteRunnableInterrupt {

    public static void main(String[] args) {
        System.out.println("Main thread stated...");
        Thread t = new Thread(new MyRunnable(), "MyRunnable");
        t.start();

        try {
            Thread.sleep(150);
            t.interrupt();
            Thread.sleep(150);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.println("Main thread finished...");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1;

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("loop " + counter++);
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
