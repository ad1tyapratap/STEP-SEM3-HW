public class Q4_JavaBeanGettersSetters {

    static class Student {
        private String name;
        private int attendance;
        private boolean scholarshipHolder;

        public Student() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAttendance() {
            return attendance;
        }

        public void setAttendance(int attendance) {
            this.attendance = attendance;
        }

        public boolean isScholarshipHolder() {
            return scholarshipHolder;
        }

        public void setScholarshipHolder(boolean scholarshipHolder) {
            this.scholarshipHolder = scholarshipHolder;
        }
    }

    public static void main(String[] args) {
        Student s = new Student();

        s.setName("Rahul");
        s.setAttendance(90);
        s.setScholarshipHolder(true);

        System.out.println("Name: " + s.getName());
        System.out.println("Attendance: " + s.getAttendance());
        System.out.println("Scholarship: " + s.isScholarshipHolder());
    }
}