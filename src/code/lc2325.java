package code;


import java.util.HashMap;

public class lc2325 {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < key.length() && map.size() < 26; i++) {
            char c = key.charAt(i);
            if (c == ' ') continue;
            if (map.get(c) == null) {
                char p = (char) ('a' + map.size());
                map.put(c, p);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                res.append(' ');
            } else {
                res.append(map.get(message.charAt(i)));
            }
        }
        return res.toString();
    }
}
