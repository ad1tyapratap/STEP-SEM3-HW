public class Q1_HostelLaundryQueue {

    interface WashType {
        int getDuration();
        double getCharge();
        String getName();
    }

    static class QuickWash implements WashType {
        public int getDuration() { return 30; }
        public double getCharge() { return 20; }
        public String getName() { return "Quick"; }
    }

    static class NormalWash implements WashType {
        public int getDuration() { return 45; }
        public double getCharge() { return 30; }
        public String getName() { return "Normal"; }
    }

    static class HeavyWash implements WashType {
        public int getDuration() { return 60; }
        public double getCharge() { return 45; }
        public String getName() { return "Heavy"; }
    }

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class WashCycle {
        Student student;
        WashingMachine machine;
        WashType type;

        WashCycle(Student student, WashingMachine machine, WashType type) {
            this.student = student;
            this.machine = machine;
            this.type = type;
        }
    }

    static class WashingMachine {
        String id;
        private WashCycle currentCycle;

        WashingMachine(String id) {
            this.id = id;
        }

        void startWash(Student student, WashType type) {
            if (currentCycle != null) {
                System.out.println("Machine " + id + " is currently busy.");
                return;
            }

            currentCycle = new WashCycle(student, this, type);

            System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
                    type.getName(), id, student.name,
                    type.getDuration(), type.getCharge());
        }

        void completeCycle() {
            if (currentCycle != null) {
                System.out.println(id + " cycle completed.");
                currentCycle = null;
                System.out.println(id + " is now free.");
            }
        }
    }

    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());

        m1.completeCycle();
        m1.startWash(neha, new NormalWash());
    }
}