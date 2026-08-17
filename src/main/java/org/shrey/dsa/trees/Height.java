package org.shrey.dsa.trees;

public class Height {

    public int height(Node root) {
        if(root == null) return 0;

        return solver(root);
    }

    public int solver(Node root) {
        if(root == null) return 0;

        int left = solver(root.left);
        int right = solver(root.right);

        return Math.max(left, right) + 1;
    }


    public boolean isHeightBalanced(Node root) {
        if(root == null) return true;

        // return solverBalanced(root);
        return heightForBalanced(root) != -1;
    }

    public boolean solverBalanced(Node root) {
        if(root == null) return true;

        int left = height(root.left);
        int right = height(root.left);

        return Math.abs(left - right) <= 1 && solverBalanced(root.left) && solverBalanced(root.right);
    }

    public int heightForBalanced(Node root) {
        if(root == null) return 0;

        int left = height(root.left);
        if(left == -1) return -1;
        
        int right = height(root.right);
        if(right == -1) return -1;

        int diff = Math.abs(left - right);
        if(diff > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
