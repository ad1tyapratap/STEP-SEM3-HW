public class Q6_ImmutableObject {

    static final class EnrollmentRecord {
        private final String regNo;
        private final String course;
        private final int year;

        EnrollmentRecord(String regNo, String course, int year) {
            this.regNo = regNo;
            this.course = course;
            this.year = year;
        }

        public String getRegNo() {
            return regNo;
        }

        public String getCourse() {
            return course;
        }

        public int getYear() {
            return year;
        }

        public EnrollmentRecord withCourse(String newCourse) {
            return new EnrollmentRecord(regNo, newCourse, year);
        }
    }

    public static void main(String[] args) {
        EnrollmentRecord e1 =
                new EnrollmentRecord("SRM101", "Java", 2026);

        EnrollmentRecord e2 = e1.withCourse("Python");

        System.out.println("Original Course: " + e1.getCourse());
        System.out.println("New Course: " + e2.getCourse());
    }
}