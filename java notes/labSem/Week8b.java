
class Buffer {
    int item;
    boolean produced = false;

    synchronized void produce(int x) {
        if (produced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception caught whoowhoo " + e);
            }
        }
        item = x;
        System.out.println("Producer - Produced Item -->" + item);
        produced = true;
        notify();
    }

    synchronized int consume() {
        if (!produced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception caught whoowhoo " + e);
            }
        }
        System.out.println("Consumer - Consumed Item -->" + item);
        produced = false;
        notify();
        return item;
    }
}

class Producer extends Thread {
    Buffer b;

    public Producer(Buffer b) {
        this.b = b;
        start();
    }

    public void run() {
        b.produce(10);
        b.produce(20);
        b.produce(30);
        b.produce(40);
        b.produce(50);
        b.produce(60);
        b.produce(70);
        b.produce(80);
        b.produce(90);
        b.produce(100);
    }
}

class Consumer extends Thread {
    Buffer b;

    public Consumer(Buffer b) {
        this.b = b;
        start();
    }

    public void run() {
        b.consume();
        b.consume();
        b.consume();
        b.consume();
        b.consume();
        b.consume();
    }

}

public class Week8b {

    public static void main(String[] args) {
        Buffer b = new Buffer();
        new Producer(b);
        System.out.println();
        new Consumer(b);
    }

}