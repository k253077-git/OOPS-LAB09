package Innerclass;

interface IoTDevice {
    default void update() {
        System.out.println("Device software");
    }

    static void info() {
        System.out.println("IoT Device");
    }
}
class SmartFan implements IoTDevice {

    void turnOn() {
        System.out.println("Fan is ON");
    }
}
public class IOT {
    public static void main(String[] args) {

        SmartFan fan = new SmartFan();
        fan.update();
        IoTDevice.info();
        fan.turnOn();
    }
}
