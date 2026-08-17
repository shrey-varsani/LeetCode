package org.shrey.dsa.trees;

import java.util.*;

public class BoundryTraversal {
    public List<Integer> boundary(Node root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);

        leftBoundry(root.left, res);
        return res;
    }

    public void leftBoundry(Node root, List<Integer> res) {
        Node curr = root;

        while(curr != null) {
            res.add(curr.val);
            curr = curr.left;
        }
    }

    public void leaves(Node root, List<Integer> res) {

    }

    public void rightBoundry(Node root, List<Integer> res) {
        
    }
}
