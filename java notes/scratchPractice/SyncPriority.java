class Counter {
    synchronized void printCount(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i * n);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}

class SyncThread extends Thread {
    Counter c;

    SyncThread(Counter c, String name, int prio) {
        super(name);
        this.c = c;
        setPriority(prio);
    }

    public void run() {
        c.printCount(10);
    }
}

public class SyncPriority {
    public static void main(String[] args) {
        Counter obj = new Counter();
        SyncThread t1 = new SyncThread(obj, "Low", Thread.MAX_PRIORITY);
        SyncThread t2 = new SyncThread(obj, "High", Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}