package Innerclass;
interface Fraud{
    void show();
}
interface Audit{
    void display();
}
public class Bank {
    static void main(String[] args) {
        Fraud f1=new Fraud(){
            @Override
            public void show(){
                System.out.println("Fraud detection");
            }
        };
        Audit a1= new Audit(){
            @Override
            public void display(){
                System.out.println("Audit verified");
            }
        };
        f1.show();
        a1.display();
    }
}
