public class Q2_ProtectedInheritance {

    static class FeeAccount {
        protected double amountPaid = 5000;

        protected void display() {
            System.out.println("Amount Paid: " + amountPaid);
        }
    }

    static class HostelFeeAccount extends FeeAccount {
        void show() {
            display();
            System.out.println("Access through inheritance: " + amountPaid);
        }
    }

    public static void main(String[] args) {
        HostelFeeAccount obj = new HostelFeeAccount();
        obj.show();
    }
}