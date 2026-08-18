package org.shrey.dsa.trees;

import java.util.*;

public class BoundryTraversal {
    public List<Integer> boundary(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res; 

        if(!isLeaf(root)) res.add(root.val);

        leftBoundry(root.left, res);
        leaves(root, res);
        rightBoundry(root, res);

        return res;
    }

    public void leftBoundry(Node root, List<Integer> res) {
        Node curr = root;

        while(curr != null) {
            if(!isLeaf(curr)) {
                res.add(curr.val);
            }
            if(curr.left != null) curr = curr.left;
            else {
                 curr = curr.right;
            }
        }
    }

    public boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public void leaves(Node root, List<Integer> res) {
        // level order for all leaves
        if(isLeaf(root)) { res.add(root.val); return; }
        if(root.left != null) {
            leaves(root.left, res);
        } 
        if(root.right != null) {
            leaves(root.right, res);
        }
    }

    public void rightBoundry(Node root, List<Integer> res) {
        Node curr = root.right;

        List<Integer> temp = new ArrayList<>();

        while(curr != null) {
            if(!isLeaf(curr)) {
                temp.add(curr.val);
            }

            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        // reverse now 
        for(int i=temp.size() - 1; i>=0; i--) {
            res.add(temp.get(i));
        }
    }
}
