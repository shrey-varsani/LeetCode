package org.shrey.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

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
}
