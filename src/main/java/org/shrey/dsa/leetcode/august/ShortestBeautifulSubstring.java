package org.shrey.dsa.leetcode.august;

public class ShortestBeautifulSubstring {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int len = s.length();

        for(int i=0; i<len; i++) {
            int one = 0;

            StringBuilder curr = new StringBuilder();

            for(int j=i; j<len; j++) {
                curr.append(s.charAt(j));

                if(s.charAt(j) == '1') {
                    one++;
                }

                if(one > k) break;

                if(one == k) {
                    String str = curr.toString();

                    if(res.isEmpty() || str.length() < res.length() || 
                    (str.length() == res.length() && str.compareTo(res) < 0)) {
                        res = str;
                    }
                }
            }
        }

        return res;
    }
}
