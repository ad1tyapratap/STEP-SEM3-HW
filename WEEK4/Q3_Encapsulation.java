public class Q3_Encapsulation {

    static class FeeAccount {
        private double totalFee;
        private double amountPaid;

        FeeAccount(double totalFee) {
            this.totalFee = totalFee;
        }

        public void pay(double amount) {
            if (amount <= 0) {
                System.out.println("Payment rejected: must be positive");
                return;
            }

            amountPaid += amount;
            System.out.println("Payment successful");
        }

        public double getDue() {
            return totalFee - amountPaid;
        }
    }

    public static void main(String[] args) {
        FeeAccount acc = new FeeAccount(100000);

        acc.pay(20000);
        System.out.println("Remaining Fee: " + acc.getDue());

        acc.pay(-500);
    }
}