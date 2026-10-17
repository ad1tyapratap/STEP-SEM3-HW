public class Q4_MonthlyAttendanceAnnouncer {

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
            System.out.print("Standard | Sessions: " + sessionsAttended);
        }
    }

    static class PremiumMember extends GymMember {
        String trainerName;

        public PremiumMember(String id, int fee, String trainer) {
            super(id, fee);
            trainerName = trainer;
        }

        @Override
        void displayInfo() {
            System.out.print("Premium | Trainer: " + trainerName
                    + " | Sessions: " + sessionsAttended);
        }

        String getTrainerName() {
            return trainerName;
        }
    }

    static String batchPrint(GymMember[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMember m : members) {
            java.io.ByteArrayOutputStream buffer =
                    new java.io.ByteArrayOutputStream();

            java.io.PrintStream old = System.out;

            System.setOut(new java.io.PrintStream(buffer));
            m.displayInfo();
            System.setOut(old);

            result.append(buffer.toString());

            if (m instanceof PremiumMember) {
                PremiumMember p = (PremiumMember) m;
                result.append(" [Trainer via downcast: ")
                      .append(p.getTrainerName())
                      .append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}