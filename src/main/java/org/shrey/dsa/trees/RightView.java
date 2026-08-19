package org.shrey.dsa.trees;

import java.util.*;

public class RightView {
    public List<Integer> rightView(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int currSize = que.size();

            for(int i=0; i<currSize; i++) {
                Node curr = que.poll();
                if(i == currSize - 1) {
                    res.add(curr.val);
                }

                if(curr.left != null) {
                    que.offer(curr.left);
                }

                if(curr.right != null) {
                    que.offer(curr.right);
                }
            }
        }

        return res;
    }
}
