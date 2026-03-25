package Innerclass;

interface Gps {
    void show();
}
interface payment{
    void display();
}
class Comp{
    static class rules{
        void rules(){
            System.out.println("rules followed");
        }
    }
}
class Ride implements payment,Gps{
    @Override
    public void show() {
        System.out.println("show gps system");
    }
    @Override
    public void display() {
        System.out.println("display payment system");
    }

}

public class Rider {
    public static void main(String[] args) {
        Ride r1=new Ride();
        r1.display();
        r1.show();

        Comp.rules r2=new Comp.rules();
        r2.rules();
    }
}
