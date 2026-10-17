public class Q2_ReferenceDeskSubclassReach {

    static String classifyAccess(String modifier, String context) {
        if (modifier.equals("public"))
            return "ALLOWED";

        if (context.equals("SAME_CLASS"))
            return "ALLOWED";

        if (modifier.equals("private"))
            return "DENIED";

        if (modifier.equals("default")) {
            if (context.equals("SAME_PACKAGE"))
                return "ALLOWED";
            return "DENIED";
        }

        if (modifier.equals("protected")) {
            if (context.equals("SAME_PACKAGE"))
                return "ALLOWED";

            if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";

            return "DENIED";
        }

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];

            if (classifyAccess(modifier, context).equals("DENIED")) {
                return modifier + " via " + context
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(firstDeniedAttempt(attempts));
    }
}