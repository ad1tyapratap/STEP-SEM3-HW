public class Q2_ThreeTiersGymMembership {

    static class GymMember {
        String memberId;
        int monthlyFee;
        int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4)
                throw new IllegalArgumentException("Invalid Member ID");

            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }

        void attendSession() {
            sessionsAttended++;
        }

        int getSessionsAttended() {
            return sessionsAttended;
        }

        void displayInfo() {
            System.out.println("Standard Member | Sessions: " + sessionsAttended);
        }
    }

    static class PremiumMember extends GymMember {
        String trainerName;

        public PremiumMember(String id, int fee, String trainerName) {
            super(id, fee);
            this.trainerName = trainerName;
        }

        @Override
        void displayInfo() {
            System.out.println("Premium Member | Trainer: " + trainerName
                    + " | Sessions: " + sessionsAttended);
        }
    }

    static class EliteMember extends PremiumMember {
        String lockerNumber;

        public EliteMember(String id, int fee, String trainer, String locker) {
            super(id, fee, trainer);
            lockerNumber = locker;
        }

        @Override
        void displayInfo() {
            System.out.println("Elite Member | Trainer: " + trainerName
                    + " | Locker: " + lockerNumber
                    + " | Sessions: " + sessionsAttended);
        }
    }

    static class GroupClassMember extends GymMember {
        String className;

        public GroupClassMember(String id, int fee, String className) {
            super(id, fee);
            this.className = className;
        }

        @Override
        void displayInfo() {
            System.out.println("Group Class Member | Class: " + className
                    + " | Sessions: " + sessionsAttended);
        }
    }

    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";

        if (member instanceof PremiumMember)
            return "Second generation";

        return "Base generation";
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        for (GymMember m : members)
            total += m.getSessionsAttended();

        return total;
    }

    public static void main(String[] args) {
        GymMember standard = new GymMember("MEM1", 1000);
        PremiumMember premium = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember elite = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember group = new GroupClassMember("MEM4", 1500, "Zumba");

        standard.displayInfo();
        premium.displayInfo();
        elite.displayInfo();
        group.displayInfo();

        System.out.println(classifyGeneration(elite));
        System.out.println(classifyGeneration(group));

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();

        elite.attendSession();
        elite.attendSession();

        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        GymMember[] members = {premium, elite, group};

        System.out.println("Total Sessions: "
                + getTotalSessionsAttended(members));
    }
}