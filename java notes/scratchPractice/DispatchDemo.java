class Shape {
    void draw() {
        System.out.println("Drawing a generic shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class DispatchDemo {
    public static void main(String[] args) {

        // Reference of parent class
        Shape ref;

        // Dynamic method dispatch starts here
        ref = new Circle();
        ref.draw();

        ref = new Rectangle();
        ref.draw();
    }
}
