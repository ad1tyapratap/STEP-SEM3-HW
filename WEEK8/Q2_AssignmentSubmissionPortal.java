import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Q2_AssignmentSubmissionPortal {

    static abstract class Assignment {
        String title;
        int maxMarks;
        LocalDate dueDate;

        Assignment(String title, int maxMarks, LocalDate dueDate) {
            this.title = title;
            this.maxMarks = maxMarks;
            this.dueDate = dueDate;
        }

        abstract double applyPenalty(double marks, long lateDays);
    }

    static class CodingAssignment extends Assignment {
        CodingAssignment(String title, int max, LocalDate due) {
            super(title, max, due);
        }

        double applyPenalty(double marks, long days) {
            return marks * Math.max(0, 1 - 0.10 * days);
        }
    }

    static class WrittenAssignment extends Assignment {
        WrittenAssignment(String title, int max, LocalDate due) {
            super(title, max, due);
            this.title = title;
        }

        double applyPenalty(double marks, long days) {
            return marks * Math.max(0, 1 - 0.20 * days);
        }
    }

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class Submission {
        Student student;
        Assignment assignment;
        LocalDate submitDate;
        private String status = "Submitted";
        private double finalMarks;

        Submission(Student s, Assignment a, LocalDate date) {
            student = s;
            assignment = a;
            submitDate = date;

            long days = Math.max(0,
                    ChronoUnit.DAYS.between(a.dueDate, date));

            System.out.println(s.name + "'s submission for '"
                    + a.title + "' received (" +
                    (days == 0 ? "on time" : days + " days late")
                    + "). Status: Submitted.");
        }

        void grade(double marks) {
            if (!status.equals("Submitted")) {
                System.out.println("Cannot grade again.");
                return;
            }

            long days = Math.max(0,
                    ChronoUnit.DAYS.between(assignment.dueDate, submitDate));

            finalMarks = assignment.applyPenalty(marks, days);
            status = "Graded";

            System.out.printf("%s graded: %.0f/%d",
                    student.name, finalMarks, assignment.maxMarks);

            if (days > 0)
                System.out.printf(" after %.0f%% late penalty",
                        days * (assignment instanceof CodingAssignment
                                ? 10.0 : 20.0));

            System.out.println(". Status: Graded.");
        }

        void resubmit() {
            if (status.equals("Graded"))
                System.out.println("Cannot resubmit: '" + assignment.title
                        + "' has already been graded.");
            else
                System.out.println("Resubmission accepted.");
        }
    }

    public static void main(String[] args) {
        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50, LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay", 50, LocalDate.of(2026, 3, 12));

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission s1 = new Submission(
                asha, coding, LocalDate.of(2026, 3, 10));

        Submission s2 = new Submission(
                ravi, written, LocalDate.of(2026, 3, 14));

        s1.grade(45);
        s2.grade(40);
        s1.resubmit();
    }
}