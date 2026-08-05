package org.shrey.dsa.leetcode.august;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RemainingMethods {
    @SuppressWarnings("unchecked")
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] edges = new ArrayList[n];

        for(int i=0; i<n; i++) {
            edges[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n];

        for(int[] inv: invocations) {
            edges[inv[0]].add(inv[1]);
            inDegree[inv[1]]++;
        }

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(k);

        boolean[] susp = new boolean[n];
        susp[k] = true;

        while(!que.isEmpty()) {
            int u = que.poll();

            for(int v: edges[u]) {
                inDegree[v]--;

                if(!susp[v]) {
                    que.offer(v);
                    susp[v] = true;
                }
            }
        }

        boolean canRemoveAll = true;
        List<Integer> rem = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(susp[i] && inDegree[i] > 0) {
                canRemoveAll = false;
                break;
            } else if(!susp[i]) {
                rem.add(i);
            }
        }

        if(!canRemoveAll) {
            List<Integer> allNodes = new ArrayList<>(n);
            for(int i=0; i<n; i++) {
                allNodes.add(i);
            }

            return allNodes;
        }

        return rem;
    }
}
