package org.shrey.dsa.leetcode.august;

public class MaximumLengthSubstringTwoRepeating {
    // aaaa 

    public int maximumLengthSubstring(String str) {
        int len = str.length();

        int[] freq = new int[26];
        int res = 0;

        int start = 0, end = 0;
        while(end < len) {
            freq[str.charAt(end) - 'a']++;

            if(freq[str.charAt(end) - 'a'] > 2) {
                // shrink window
                freq[str.charAt(start)]--;
                start++;
            }

            end++;

            res = Math.max(res, end - start);
        }

        return res;
    }
}
