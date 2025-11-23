class ThreadOne extends Thread {

    ThreadOne(String name) {
        super(name);
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + getName());
                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Something very seriously wenttt wronggg !!! u freakin idiot - fix it." + e);
        }
    }
}

public class Week8a {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne("Freakin Idiot");
        ThreadOne t2 = new ThreadOne("Gett Losttt");

        t1.start();
        t2.start();
        System.out.println("Finallly main program executedd OMG !!!");
    }
}