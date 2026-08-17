package org.shrey.dsa.trees;

public class PathSum {

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        if(root == null) return 0;

        solver(root);
        return maxSum;
    }

    public int solver(Node root) {
        if(root == null) return 0;

        int left = Math.max(0, solver(root.left));
        int right = Math.max(0, solver(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        
    }

    public Node buildTree(Integer[] arr) {
        if(arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        Node[] nodes = new Node[arr.length];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != null) {
                nodes[i] = new Node(arr[i]);
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(nodes[i] == null) continue;

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < arr.length) {
                nodes[i].left = nodes[left];
            } 

            if(right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }

        return nodes[0];
    }
}

// [1,2,3]
// [-10,9,20,null,null,15,7]