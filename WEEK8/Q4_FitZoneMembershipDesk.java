public class Q4_FitZoneMembershipDesk {

    interface MembershipPlan {
        int getMonths();
        double getDiscount();
    }

    static class MonthlyPlan implements MembershipPlan {
        public int getMonths() { return 1; }
        public double getDiscount() { return 0; }
    }

    static class QuarterlyPlan implements MembershipPlan {
        public int getMonths() { return 3; }
        public double getDiscount() { return 0.10; }
    }

    static class AnnualPlan implements MembershipPlan {
        public int getMonths() { return 12; }
        public double getDiscount() { return 0.25; }
    }

    static class Member {
        String name;

        Member(String name) {
            this.name = name;
        }
    }

    static class Membership {
        Member member;
        private String status = "Active";
        double fee;

        Membership(Member member, MembershipPlan plan) {
            this.member = member;
            fee = 1000 * plan.getMonths()
                    * (1 - plan.getDiscount());

            String planName = plan instanceof MonthlyPlan ? "Monthly"
                    : plan instanceof QuarterlyPlan ? "Quarterly" : "Annual";

            System.out.printf("%s membership created for %s. Fee: ₹%.2f. Status: Active.%n",
                    planName, member.name, fee);
        }

        void checkIn() {
            if (status.equals("Active"))
                System.out.println(member.name + " checked in successfully.");
            else
                System.out.println("Check-in denied: " + member.name
                        + "'s membership is " + status + ".");
        }

        void freeze() {
            if (status.equals("Expired")) {
                System.out.println("Cannot freeze an Expired membership.");
            } else if (status.equals("Active")) {
                status = "Frozen";
                System.out.println(member.name + "'s membership frozen.");
                System.out.println("Status: Frozen.");
            }
        }

        void unfreeze() {
            if (status.equals("Frozen")) {
                status = "Active";
                System.out.println(member.name + "'s membership unfrozen.");
            }
        }

        void expire() {
            status = "Expired";
            System.out.println(member.name + "'s membership expired.");
            System.out.println("Status: Expired.");
        }
    }

    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership m1 = new Membership(asha, new QuarterlyPlan());
        Membership m2 = new Membership(ravi, new MonthlyPlan());

        m1.checkIn();
        m1.freeze();
        m1.checkIn();

        m2.expire();
        m2.freeze();
    }
}