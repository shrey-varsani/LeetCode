package org.shrey.dsa.trees;

import java.util.*;

public class Traversals {
    public void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.val + " ");
    }

    public void levelOrder(Node root) {
        if(root == null) return;
        
        Queue<Node> que = new LinkedList<>();

        que.offer(root);
        while(!que.isEmpty()) {
            Node curr = que.poll();

            System.out.print(curr.val + " ");
            //offer children to que

            while(curr.left != null) {
                que.offer(curr.left);
            }

            while(curr.right != null) {
                que.offer(curr.right);
            }
        }
    }

    public void allInOneRecur(Node root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        if(root == null) return;
        pre.add(root.val);

        allInOneRecur(root.left, pre, in, post);

        in.add(root.val);

        allInOneRecur(root.right, pre, in, post);

        post.add(root.val);
    }

    public List<List<Integer>> allInOne(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> stk = new Stack<>();
        stk.add(new Pair(root, 1));

        while(!stk.isEmpty()) {
            Pair curr = stk.pop();
            Node currNode = curr.node;
            int currPos = curr.pos;

            switch(currPos) {
                case 1 -> {
                    pre.add(currNode.val);
                    currPos++;
                    stk.push(curr);

                    if(currNode.left != null) {
                        stk.push(new Pair(currNode.left, 1));
                    }
                }
                case 2 -> {
                    in.add(currNode.val);
                    currPos++;
                    stk.push(curr);

                    if(currNode.right != null) {
                        stk.push(new Pair(currNode.right, 1));
                    }
                }
                default -> post.add(currNode.val);
            }
        }

        res.add(pre);
        res.add(in);
        res.add(post);
        return res;
    }
}

class Pair {
    Node node;
    int pos;

    public Pair(Node root, int pos){
        this.node = root;
        this.pos = pos;
    }
}
