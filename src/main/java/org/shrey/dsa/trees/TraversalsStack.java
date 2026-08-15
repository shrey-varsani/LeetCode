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

    public List<Integer> postOrder2Stacks(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        List<Integer> res = new ArrayList<>();

        Node curr = root;
        s1.push(curr);
        while(!s1.isEmpty()) {
            curr = s1.pop();

            s2.push(curr);      // before adding children add that node in 2nd stack

            if(curr.left != null) s1.push(curr.left);
            if(curr.right != null) s1.push(curr.right);
        }

        while(!s2.isEmpty()) {
            res.add(s2.pop().val);
        }

        return res;
    }

    public List<Integer> postOrder1Stack(Node root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;
        Stack<Node> stk = new Stack<>();

        Node curr = root;
        Node lastVisit = null;
        stk.push(curr);

        while(!stk.isEmpty()) {
            if(curr != null) {
                stk.push(curr);
                curr = curr.left;
            }

            Node peek = stk.pop();
            if(peek.right != null && lastVisit != peek.right) {
                curr = peek.right;
            } else {
                res.add(peek.val);
                lastVisit = stk.pop();
            }
        }

        return res;
    }
}


