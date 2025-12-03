package Programs;
// Java Lab Week - 8 (a) Program
class Thread1 extends Thread {
  Thread1(String name) {
    super(name);
    // start();
  }

  public void run() {
    try {
      for (int i = 0; i <= 4; i++) {
        System.out.println("Java is Object Oriented " + getName());
        sleep(1000);
      }
    } catch (InterruptedException ie) {
      System.out.println("Child Thread - Exception caught " + ie);
    }
  }
}

public class MultiThreads {
  public static void main(String[] args) {

    Thread1 t1 = new Thread1("First Thread");
    Thread1 t2 = new Thread1("Second Thread");

    t1.start();
    t2.start();
    System.out.println("Main Program");
  }
}
