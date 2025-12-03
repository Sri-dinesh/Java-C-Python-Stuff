// Single inheritance
class A {
    void showA() {
        System.out.println("This is class A");
    }
}

class B extends A {
    void showB() {
        super.showA();
        System.out.println("This is class B single inheritance from A");
    }
}

// Multilevel inheritance
class C extends B {
    void showC() {
        super.showB();
        System.out.println("This is class C multilevel inheritance from B");
    }
}

// Hierarchical inheritance
class D extends A {
    void showD() {
        System.out.println("This is class D hierarchical inheritance from A");
    }
}

// Multiple inheritance using interface
interface X {
    void showX();
}

interface Y {
    void showY();
}

class E implements X, Y {
    public void showX() {
        System.out.println("From interface X");
    }

    public void showY() {
        System.out.println("From interface Y");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {

        System.out.println("Single Inheritance");
        B obj1 = new B();
        obj1.showB();

        System.out.println("MultiLevel Inheritance");
        C obj2 = new C();
        obj2.showA();
        obj2.showC();

        System.out.println("Hierarchial Inheritance");
        D obj3 = new D();
        obj3.showA();
        obj3.showD();

        System.out.println("Multiple Inheritance through Interfaces");
        E obj4 = new E();
        obj4.showX();
        obj4.showY();
    }
}
