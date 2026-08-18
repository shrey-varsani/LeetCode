package org.shrey.dsa.trees;

import java.util.*;

public class TopView {
    public List<Integer> topView(Node root) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(root.val, 0);
        
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0));

        while(!que.isEmpty()) {
            Pair curr = que.poll();
            Node node = curr.node;
            int dist = curr.row;

            if(!map.containsKey(node.val)) {
                map.put(dist, node.val);        // key, value => row, node value
            }

            if(node.left != null) {
                que.offer(new Pair(node.left, dist - 1));
            }

            if(node.right != null) {
                que.offer(new Pair(node.right, dist + 1));
            }
        }

        res.addAll(map.values());
        return res;
 
    } 

    static class Pair {
        Node node;
        int row;

        public Pair(Node node, int row) {
            this.node = node;
            this.pair = pair;
        }
    }
}
