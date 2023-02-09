package code;

import java.util.*;

/*
https://leetcode.cn/problems/design-authentication-manager/
 */
public class lc1797 {
    class AuthenticationManager {
        private int timeToLive;
        private HashMap<String, Long> map = null;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            this.clear(currentTime);
            long t = this.timeToLive + currentTime;
            this.map.put(tokenId, t);
        }

        public void renew(String tokenId, int currentTime) {
            this.clear(currentTime);
            if (this.map.containsKey(tokenId)) {
                long t = this.timeToLive + currentTime;
                this.map.put(tokenId, t);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            this.clear(currentTime);
            return this.map.size();
        }

        private void clear(int currentTime) {
            Iterator<Map.Entry<String, Long>> iterator = this.map.entrySet().iterator();
            while (iterator.hasNext()) {
                long t = iterator.next().getValue();
                if (t <= currentTime) iterator.remove();
            }
        }
    }
}
