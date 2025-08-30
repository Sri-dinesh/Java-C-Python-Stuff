import java.util.*;
import packagesDemo.*;
import packagesDemo.Laptop;

class Something implements Laptop.print {
    public void shape() {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PackageDemo pack = new PackageDemo();
        System.out.println(pack.sum(10, 20));

        System.out.println(pack.namePrint("sridinesh"));

        Laptop l = new Laptop();
        System.out.println(l.name);

        System.out.println(l.printName("Java Programming !!!"));

        Something s = new Something();
        s.shape();

        sc.close();

    }
}