package thread;

public class CommonResource2 {

    int x;

    synchronized void increment() {

        x = 1;
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        CommonResource2 commonResource2 = new CommonResource2();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CountThread1(commonResource2));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class CountThread1 implements Runnable {

    CommonResource2 res;

    public CountThread1(CommonResource2 res) {
        this.res = res;
    }

    @Override
    public void run() {
        res.increment();
    }
}
