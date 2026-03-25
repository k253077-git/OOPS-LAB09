package Innerclass;

interface OnlinePayment {
    default void pay() {
        System.out.println("Online Payment");
    }
}
interface CashPayment {
    default void pay() {
        System.out.println("Cash Payment");
    }
}

abstract class OrderBase {
    String orderId;

    OrderBase(String orderId) {
        this.orderId = orderId;
    }

    abstract void processOrder();
}

class SmartOrder extends OrderBase implements OnlinePayment, CashPayment {

    class Invoice {
        void showInvoice() {
            System.out.println("Invoice for order: " + orderId);
        }
    }

    Invoice invoice;
    SmartOrder(String orderId) {
        super(orderId);
        invoice = new Invoice();
    }
    @Override
    void processOrder() {
        System.out.println("Processing order: " + orderId);
    }

    @Override
    public void pay() {
        System.out.println("Processing payments for order: " + orderId);
        OnlinePayment.super.pay();
        CashPayment.super.pay();
    }

    void showInvoice() {
        invoice.showInvoice();
    }
}

public class Order {
    public static void main(String[] args) {

        SmartOrder order = new SmartOrder("New123");

        order.processOrder();
        order.pay();
        order.showInvoice();
    }
}