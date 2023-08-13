package code;

/*
https://leetcode.cn/problems/masking-personal-information/
 */
public class lc831 {
    public String maskPII(String s) {
        if (s.contains("@")) {
            // email
            s = s.toLowerCase();
            String name = s.substring(0, s.indexOf("@"));
            String n = s.substring(s.indexOf("@"));
            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + n;
        }
        String nums = s.replace("(", "")
                .replace(")", "")
                .replace("-", "")
                .replace("+","");
        return "";
    }
}
