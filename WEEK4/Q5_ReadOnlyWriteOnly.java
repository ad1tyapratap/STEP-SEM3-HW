public class Q5_ReadOnlyWriteOnly {

    static class Student {
        private final String regNo;
        private String name;

        Student(String regNo, String name) {
            this.regNo = regNo;
            this.name = name;
        }

        public String getRegNo() {
            return regNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Account {
        private String password;

        public void setPassword(String password) {
            this.password = password;
        }

        public void displayStatus() {
            System.out.println("Password stored: " + (password != null));
        }
    }

    public static void main(String[] args) {
        Student s = new Student("SRM101", "Rahul");

        System.out.println("Register Number: " + s.getRegNo());

        s.setName("Aman");
        System.out.println("Name: " + s.getName());

        Account a = new Account();
        a.setPassword("abc123");
        a.displayStatus();
    }
}