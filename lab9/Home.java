package Innerclass;

abstract class Appliance {
    String name;

    Appliance(String name) {
        this.name = name;
    }

    abstract void turnOn();
}
interface VoiceControl {
    default void executeCommand() {
        System.out.println("Voice Control");
    }
}
interface RemoteControl {
    default void executeCommand() {
        System.out.println("Remote Control");
    }
}

class SmartAppliance extends Appliance implements VoiceControl, RemoteControl {
    class Settings {
        void showSettings() {
            System.out.println(name + " Settings done");
        }
    }

    Settings s1;

    SmartAppliance(String name) {
        super(name);
        s1 = new Settings();
    }

    // Implement abstract method
    @Override
    void turnOn() {
        System.out.println("Turning on appliance: " + name);
    }

    // Resolve conflict between interfaces
    @Override
    public void executeCommand() {
        System.out.println("Smart Appliance");
        VoiceControl.super.executeCommand();
        RemoteControl.super.executeCommand();
    }

    void showSettings() {
        s1.showSettings();
    }
}
public class Home {
    public static void main(String[] args) {

        SmartAppliance light = new SmartAppliance("Light");
        light.turnOn();
        light.executeCommand();
        light.showSettings();
    }
}
