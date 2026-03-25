package Innerclass;

abstract class vech {
    String model;

    vech(String model) {
        this.model = model;
    }

    abstract void start();
}
interface Electricsys {
    default void showStatus() {
        System.out.println("Electric system");
    }
}
interface GPS{
    default void showStatus() {
        System.out.println("GPS system");
    }
}
class SmartVehicle extends vech implements Electricsys, GPS {

    class Engine {
        void engineInfo() {
            System.out.println("Engine operated.");
        }
    }
    Engine engine; // composition

    SmartVehicle(String model) {
        super(model);
        engine = new Engine();
    }

    // Implement abstract method

    void start() {
        System.out.println("Starting Vehicle:" + model);
    }

    // Resolve conflict (same method in interfaces)
    @Override
    public void showStatus() {
        System.out.println("Vehicle Status:");

        Electricsys.super.showStatus();
        GPS.super.showStatus();
    }
    void display() {
        engine.engineInfo();
    }
}

public class Vehicle {
    public static void main(String[] args) {

        SmartVehicle car = new SmartVehicle("Corolla");
        car.start();
        car.showStatus();
        car.display();
    }
}
