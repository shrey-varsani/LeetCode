package org.shrey.dsa.trees;

import java.util.*;

public class BottomView {
    public List<Integer> bottomView(Node root) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // dist => key, Node -> value 

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0));

        while(!que.isEmpty()) {
            Pair curr = que.poll();
            Node currNode = curr.node;
            int currDist = curr.dist;

            map.put(currDist, currNode.val);
            
           if(currNode.left != null) {
                que.offer(new Pair(currNode.left, currDist - 1));
           }

           if(currNode.right != null) {
            que.offer(new Pair(currNode.right, currDist + 1));
           }
            
        }

        for(int value: map.values()) {
            res.add(value);
        }

        return res;
    }
}
class Pair {
    Node node;
    int dist;

    public Pair(Node node, int dist) {
        this.node = node;
        this.dist = dist;
    } 
}