import java.util.*;

public class Q5_CampusNoticeBroadcaster {

    interface NotificationChannel {
        void send(String student, String message);
    }

    static class EmailChannel implements NotificationChannel {
        public void send(String student, String message) {
            System.out.println("[Email → " + student + "] " + message);
        }
    }

    static class SmsChannel implements NotificationChannel {
        public void send(String student, String message) {
            System.out.println("[SMS → " + student + "] " + message);
        }
    }

    static class AppChannel implements NotificationChannel {
        public void send(String student, String message) {
            System.out.println("[App → " + student + "] " + message);
        }
    }

    static class Student {
        String name;
        String department;
        List<NotificationChannel> channels = new ArrayList<>();

        Student(String name, String department) {
            this.name = name;
            this.department = department;
        }

        void addChannel(NotificationChannel channel) {
            channels.add(channel);
        }
    }

    static class Notice {
        String title;
        Set<String> departments;

        Notice(String title, String... departments) {
            if (title == null || title.trim().isEmpty())
                throw new IllegalArgumentException("Title is required");

            if (departments.length == 0)
                throw new IllegalArgumentException(
                        "At least one target department is required");

            this.title = title;
            this.departments = new LinkedHashSet<>(
                    Arrays.asList(departments));
        }
    }

    static class NoticeBoard {
        List<Student> students = new ArrayList<>();

        void addStudent(Student student) {
            students.add(student);
        }

        void postNotice(Notice notice) {
            System.out.println("Notice '" + notice.title
                    + "' posted to " + String.join(", ", notice.departments) + ".");

            for (Student s : students) {
                if (notice.departments.contains(s.department)) {
                    for (NotificationChannel c : s.channels)
                        c.send(s.name, notice.title);
                }
            }
        }
    }

    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha = new Student("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi = new Student("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        board.addStudent(asha);
        board.addStudent(ravi);

        board.postNotice(new Notice("Lab Closed Tomorrow", "CSE"));
        board.postNotice(new Notice("Fee Deadline Extended", "CSE", "ECE"));

        try {
            board.postNotice(new Notice("Sports Day"));
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot post notice: "
                    + e.getMessage() + ".");
        }
    }
}