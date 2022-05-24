package thread;

public class InfiniteThreadInterrupt {

    public static void main(String[] args) {
        System.out.println("Main thread stated...");
        JThreadInter myThread = new JThreadInter("MyThread");
        myThread.start();

        try {
            Thread.sleep(150);
            myThread.interrupt();
            Thread.sleep(150);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.println("Main thread finished...");
    }

}

class JThreadInter extends Thread {

    public JThreadInter(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1;

        while (!isInterrupted()) {
            System.out.println("loop " + counter++);
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
