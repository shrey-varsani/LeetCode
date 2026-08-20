package org.shrey.dsa.trees;

public class Symmetric {
    public boolean isSymmetric(Node root) {
        if(root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(Node node1, Node node2) {
        if(node1 == null || node2 == null) {
            return node1 == node2;
        }

        return (node1.val == node2.val && 
        isMirror(node1.left, node2.right) && 
        isMirror(node1.right, node2.left));
    }
}
