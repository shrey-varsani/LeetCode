package org.shrey.dsa.trees;

public class SameTree {
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null) return true;

        return getValue(p, q);
    }

    public boolean getValue(Node p, Node q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        boolean isLeft = getValue(p.left, q.left);
        boolean isRight = getValue(p.right, q.right);

        return (p.val == q.val && isLeft == isRight);
    }
}
