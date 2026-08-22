package org.shrey.dsa.trees;

import java.util.*;

public class CheckValues {
    public boolean check(Node root) {
        if(root == null) return true;

        boolean hasLeafFound = false;

        Queue<Node> que = new LinkedList<>();
        while(!que.isEmpty()) {
            int size = que.size();

            for(int i=0; i<size; i++) {
                Node curr = que.poll();

                if(curr.left == null && curr.right == null) hasLeafFound = true;

                else {
                    // no leaf has found => just add children
                    hasLeafFound = false;

                    if(curr.left != null) que.offer(curr.left);

                    if(curr.right != null) {
                        que.offer(curr.right);
                    }
                }
            }

            // different than last level
            // another leaf found => return false
            if(hasLeafFound) {
                return que.isEmpty();
            }
        }

        return true;
    }

    // recursive approach
    private int leafLevel = -1;
    public boolean checkLeavesSameLevel(Node root) {
        leafLevel = -1;
        return checkForSameLevel(root, leafLevel);
    }
    
    public boolean checkForSameLevel(Node root, int currlevel) {
        if(root == null) return true;

        if(root.left == null && root.right == null) {
            // founded leaf => note the level
            if(leafLevel == -1) { // first time leaf is found
                leafLevel = currlevel;
                return true;
            }
            // check if different level

            // if diff => return false
            return currlevel == leafLevel;
        }

        return checkForSameLevel(root.left, currlevel) && checkForSameLevel(root.right, currlevel);
    }
}
