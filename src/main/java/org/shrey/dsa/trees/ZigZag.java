package org.shrey.dsa.trees;

import java.util.*;

public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        boolean isEven = true;
        while(!que.isEmpty()) {
            int currLevelSize = que.size();
  
            List<Integer> temp = new LinkedList<>();

            for(int i=0; i<currLevelSize; i++) {
                Node curr = que.poll();
                
                temp.add(curr.val);

                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
   
            }

            if(!isEven) {
                    Collections.reverse(temp);
            }

            res.add(temp);
            isEven = !isEven;
        }

        return res;
    }
}
