package thread;

import java.util.concurrent.Semaphore;

public class TaskPhilosopher {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);

        for (int i = 0; i < 6; i++) {
            new Philosopher(sem, i).start();
        }
    }
}

class Philosopher extends Thread {
    Semaphore sem;

    int num = 0;

    int id;

    Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (num < 3) {
                sem.acquire();
                System.out.println("Философ " + id + " садиться за стол");
                sleep(500);

                num++;

                System.out.println("Философ " + id + " выходит из-за стол");
                sem.release();
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Философу " + id + " плохо");
        }
    }
}
