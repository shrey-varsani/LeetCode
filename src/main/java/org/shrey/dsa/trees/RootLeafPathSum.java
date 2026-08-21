package org.shrey.dsa.trees;

public class RootLeafPathSum {
    public boolean hasPathSum(Node root, int target) {
        if(root == null) return false;

        target -= root.val;

        if(root.left != null && root.right != null) {
            return target == 0;
        }

       return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }
}
