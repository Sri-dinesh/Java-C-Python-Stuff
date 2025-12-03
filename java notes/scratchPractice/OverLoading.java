class OverloadExample {

    int a;
    int b;

    OverloadExample() {
        a = 0;
        b = 0;
    }

    OverloadExample(int x) {
        a = x;
        b = 0;
    }

    OverloadExample(int x, int y) {
        a = x;
        b = y;
    }

    void show() {
        System.out.println("Values are: " + a + " and " + b);
    }

    void show(int x) {
        System.out.println("Square is: " + (x * x));
    }
}

public class OverLoading {
    public static void main(String[] args) {

        OverloadExample obj1 = new OverloadExample();
        OverloadExample obj2 = new OverloadExample(10);
        OverloadExample obj3 = new OverloadExample(5, 15);

        obj1.show();
        obj2.show();
        obj3.show();

        obj3.show(6);
    }
}
