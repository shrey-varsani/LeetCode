package org.shrey.dsa.leetcode.august;

import java.util.*;

public class LargestIntegerKSizeWindow {
    public int largestInteger(int[] arr, int k) {
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        
        int[] freq = new int[51];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int key: map.keySet()) {
            freq[key]++;
        }

        // k to len
        for(int i=k; i<len; i++) {
            int remove = arr[i - k];
            map.put(remove, map.get(remove) - 1);

            if(map.get(remove) == 0) {
                map.remove(remove);
            }

            int add = arr[i];

            if(!map.containsKey(add)) {
                map.put(add, 1);

                freq[add]++;
            } else {
                map.put(add, map.getOrDefault(add, 0) + 1);
            }
            
        }

        for(int i=freq.length-1; i>=0; i--) {
            if(freq[i] == 1) {
               return i;
                // whose freq is 1 
            }
        }

        return -1;
    }   
}
