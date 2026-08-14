package org.shrey.dsa.trees;

import java.util.*;

public class TraversalsStack {
    public List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        
        Stack<Node> stk = new Stack<>();

        stk.push(root);
        while(!stk.isEmpty()) {
            Node curr = stk.pop();
            res.add(curr.val);

            if(curr.right != null) stk.push(curr.right);
            if(curr.left != null) stk.push(curr.left);
        }

        return res;
    }

    public List<Integer> inOrder(Node root) {
        List<Integer> res = new ArrayList<>();

        Stack<Node> stk = new Stack<>();

        Node curr = root;
        while(curr != null || !stk.isEmpty()) {
            while(curr != null) {
                stk.push(curr);
                curr = curr.left;
            }

            curr = stk.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }
}


