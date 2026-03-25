package Innerclass;

interface wifi{
    default void connect(){
        System.out.println("Connecting to wifi");
    }
}
interface bluetooth{
    default void connect(){
        System.out.println("Connecting to bluetooth");
    }
}
class fast{
    class dept{
        String department;

        dept(String department){
            this.department = department;
        }
        void show(){
            System.out.println("Department : "+department);
        }
    }
}
class SmartDevice implements wifi, bluetooth {

    fast.dept dept;

    // Constructor
    SmartDevice(fast.dept d) {
        dept = d;
    }

    // Resolve conflict here
    @Override
    public void connect() {
        System.out.println("Smart Device Choosing Connection:");

        // Calling both explicitly
        wifi.super.connect();
        bluetooth.super.connect();
    }

    void showInfo() {
        dept.show();
    }
}
public class Campus {
    public static void main(String[] args) {

        fast fast = new fast();

        // Creating Inner Class Object
        fast.dept csDept = fast.new dept("Computer Science");

        // Creating Smart Device
        SmartDevice device = new SmartDevice(csDept);

        device.showInfo();
        device.connect();
    }
}
