package org.shrey.dsa.trees;

import java.util.*;

/**
 * Given a root of Binary Tree. Find the sum of all the leaf nodes that are left child of their parent of the given binary tree.
 */
public class SumOfLeftLeafNodes {
    public int leftLeavesSum(Node root) {
        if(root == null) return 0;

        int sum = 0;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int size = que.size();

            for(int i=0; i<size; i++) {
                Node curr = que.poll();

                if(curr.left != null && curr.left.left != null
                    && curr.left.right != null
                ) {
                    sum += curr.left.val;
                }

                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
        }

        return sum;
    }
}
