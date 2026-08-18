package org.shrey.dsa.trees;

import java.util.*;

public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        // add root => add left and right child further and their indices (representing the column idx)
        Queue<Tuple> que = new LinkedList<>();
        que.offer(new Tuple(root, 0, 0));
        // within the same => sort => priorityQueue

        List<Tuple> nodes = new ArrayList<>();

        while(!que.isEmpty()) {
            Tuple curr = que.poll();

            nodes.add(curr);

            if(curr.node.left != null) {
                que.offer(new Tuple(curr.node.left, curr.row + 1, curr.col - 1));
            } 

            if(curr.node.right != null) {
                que.offer(new Tuple(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        nodes.sort((a, b) -> {
           if(a.col != b.col) {
                return Integer.compare(a.col, b.col);
           } 

           if(a.row != b.row) {
                return Integer.compare(a.row, b.row);
           }

           return Integer.compare(
                a.node.val, 
                b.node.val
            );
        });

        int prevCol = Integer.MIN_VALUE;
        for(Tuple curr: nodes) {
            if(curr.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = curr.col;
            }

            res.get(res.size() - 1).add(curr.node.val);
        }
        
        return res;
    }

    static class Tuple {
        Node node;
        int row;
        int col;

        public Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
