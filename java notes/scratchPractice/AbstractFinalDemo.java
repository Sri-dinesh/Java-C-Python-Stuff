abstract class Vehicle {
    final int wheels;

    Vehicle(int wheels) {
        this.wheels = wheels;
    }

    final void showWheels() {
        System.out.println("Number of wheels " + wheels);
    }

    abstract void start();
}

class Car extends Vehicle {
    Car() {
        super(4);
    }

    void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike extends Vehicle {
    Bike() {
        super(2);
    }

    void start() {
        System.out.println("Bike starts with a self button");
    }
}

public class AbstractFinalDemo {
    public static void main(String[] args) {

        Vehicle v;

        v = new Car();
        v.start();
        v.showWheels();

        v = new Bike();
        v.start();
        v.showWheels();
    }
}
