package thread;

public class Program {

    public static void main(String[] args) {
        System.out.println("Main thread stated...");
//        Thread myThread = new Thread(new MyThread(), "MyThread");
//        myThread.start();
        Runnable r = () -> {
            System.out.printf("%s started... \n", Thread.currentThread().getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        };
        Thread myThread = new Thread(r, "MyThread");
        myThread.start();
        System.out.println("Main thread finished...");
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
