package thread;

public class CommonResource {

    int x = 0;

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();

        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class CountThread implements Runnable {

    CommonResource res;

    public CountThread(CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            res.x = 1;

            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
