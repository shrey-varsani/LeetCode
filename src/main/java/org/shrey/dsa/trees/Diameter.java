package org.shrey.dsa.trees;

public class Diameter {
    public int diameter(Node root) {
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));       // root must not have been included
    }

    public int height(Node root) {
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(right, left) + 1;
    }
}
