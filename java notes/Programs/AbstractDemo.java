package Programs;

abstract class Shape {
    int b, h;

    abstract void ShapeArea(int b, int h);
}

class Triangle extends Shape {
    void ShapeArea(int b, int h) {
        double area = 0.5 * b * h;
        System.out.println(area);
    }
}

class Square extends Shape {
    void ShapeArea(int b, int h) {
        double area = b * h;
        System.out.println(area);
    }
}

public class AbstractDemo {

    public static void main(String[] args) {
        Triangle t = new Triangle();
        Square s = new Square();
        int a = 2;
        int b = 4;

        t.ShapeArea(a, b);
        s.ShapeArea(a, b);

    }
} 