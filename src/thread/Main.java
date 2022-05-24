package thread;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main thread stated...");

        JThread t = new JThread("JThread ");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");
    }

}

class JThread extends Thread {

    public JThread(String name) {
        super(name);
    }

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
