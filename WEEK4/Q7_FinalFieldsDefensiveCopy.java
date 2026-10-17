public class Q7_FinalFieldsDefensiveCopy {

    static class CourseRoster {
        private final String courseCode;
        private final int[] scores;

        CourseRoster(String courseCode, int[] scores) {
            this.courseCode = courseCode;
            this.scores = scores.clone();
        }

        public String getCourseCode() {
            return courseCode;
        }

        public int[] getScores() {
            return scores.clone();
        }
    }

    public static void main(String[] args) {
        int[] marks = {90, 85, 76};

        CourseRoster roster = new CourseRoster("21CSC201J", marks);

        marks[0] = 0;

        int[] result = roster.getScores();
        result[1] = 0;

        System.out.println("Course: " + roster.getCourseCode());

        int[] scores = roster.getScores();

        for (int mark : scores) {
            System.out.println(mark);
        }
    }
}