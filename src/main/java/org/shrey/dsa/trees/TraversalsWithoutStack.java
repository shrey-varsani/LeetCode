package org.shrey.dsa.trees;

import java.util.*;

public class TraversalsWithoutStack {
    public List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();

        Node curr = root;
        while(curr != null) {
            if(curr.left != null) {
                Node temp = curr.left;

                while(temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if(temp.right == null) {
                    temp.right = curr;
                    res.add(curr.val);
                    curr = curr.left;
                } else {
                    temp.right = null;
                    curr = curr.right;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
            
        }

        return res;
    }

    public List<Integer> inOrder(Node root) {
        List<Integer> res = new ArrayList<>();

        Node curr = root;
        while(curr != null) {
            if(curr.left != null) {
                Node temp = curr.left;

                while(temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }
}
