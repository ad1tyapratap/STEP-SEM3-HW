public class Q1_MembershipFieldReachChecker {

    static class LibraryMember {
        private String membershipPin;
        String branchCode;
        protected double finesOwed;
        public String displayName;
    }

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
            return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < modifiers.length; i++) {
            int allowed = 0, denied = 0;

            for (int j = 0; j < attempts.length; j++) {
                if (attempts[j][0].equals(modifiers[i])) {
                    if (classifyAccess(attempts[j][0],
                            attempts[j][1]).equals("ALLOWED"))
                        allowed++;
                    else
                        denied++;
                }
            }

            if (i > 0)
                result.append(" | ");

            result.append(modifiers[i]).append(": ")
                  .append(allowed).append(" allowed / ")
                  .append(denied).append(" denied");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeByModifier(attempts));
    }
}