package org.shrey.dsa.leetcode.august;

import java.util.*;

public class LargestIntegerKSizeWindow {
    public int largestInteger(int[] arr, int k) {
        int[] freq = new int[51];

        for(int i = 0; i <= arr.length - k; i++) {

            boolean[] present = new boolean[51];

            for(int j = i; j < i + k; j++) {
                present[arr[j]] = true;
            }

            for(int x = 0; x <= 50; x++) {
                if(present[x]) {
                    freq[x]++;
                }
            }
        }

        for(int x = 50; x >= 0; x--) {
            if(freq[x] == 1) {
                return x;
            }
        }

        return -1;
    }   
}
