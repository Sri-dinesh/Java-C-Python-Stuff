import java.util.*;

abstract class Shape {

  double height;
  double base;

  void setParam(double height, double base) {
    this.height = height;
    this.base = base;
  }

  abstract void shapeArea();
}

class Triangle extends Shape {

  void shapeArea() {
    System.out.println("Area of triangle:" + 0.5 * super.base * super.height);
  }

}

class Rectangle extends Shape {
  void shapeArea() {
    System.out.println("Area of rectangle: " + super.base * super.height);
  }
}

public class ShapeDemo {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the base and height");
    double base;
    double height;

    base = sc.nextDouble();
    height = sc.nextDouble();

    Rectangle r = new Rectangle();
    r.setParam(base, height);
    r.shapeArea();

    Triangle t = new Triangle();
    t.setParam(base, height);
    t.shapeArea();

  }

}
