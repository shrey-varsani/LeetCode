package org.shrey.dsa.leetcode.august;

/*
You are given a 0-indexed string s. You are also given a 0-indexed string queryCharacters of length k and a 0-indexed array of integer indices queryIndices of length k, both of which are used to describe k queries.

The ith query updates the character in s at index queryIndices[i] to the character queryCharacters[i].

Return an array lengths of length k where lengths[i] is the length of the longest substring of s consisting of only one repeating character after the ith query is performed.
*/

public class Longest_Substring_of_One_Repeating_Character {
    class Solution {

    static class Node {
        char leftOne;
        char rightOne;

        int length, prefix, suffix, bestOne;

        Node(char leftOne, char rightOne, int length, int prefix, int suffix, int bestOne) {
            this.leftOne = leftOne;
            this.rightOne = rightOne;
            this.length = length;
            this.prefix = prefix;
            this.suffix = suffix;
            this.bestOne = bestOne;
        }
    }

    private Node[] tree;

    public Node merge(Node left, Node right) {      // merge both segments of trees
        int length = left.length + right.length;
        int prefix = left.prefix;

        if(left.rightOne == right.leftOne && left.prefix == left.length) {
            prefix = left.length + right.prefix;
        }

        int suffix = right.suffix;

        if(left.rightOne == right.leftOne && right.suffix == right.length) {
            suffix = right.length + left.suffix;
        }

        int bestOne = Math.max(left.bestOne, right.bestOne);

        if(left.rightOne == right.leftOne) {
            bestOne = Math.max(bestOne, left.suffix + right.prefix);
        }

        return new Node(left.leftOne, right.rightOne, length, prefix, suffix, bestOne);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {   // given method
        int len = s.length();

        tree = new Node[4 * len];
        build(1, 0, len - 1, s);
        int[] res = new int[queryIndices.length];

        for(int i=0; i<res.length; i++) {
            update(1, 0, len - 1, queryIndices[i], queryCharacters.charAt(i));

            res[i] = tree[1].bestOne;
        }

        return res;
    }

    public void build(int node, int start, int end, String s) {     // combine both sides
        if(start == end) {
            tree[node] = new Node(s.charAt(start), s.charAt(end), 1, 1, 1, 1);
            return;
        }

        int mid = start + (end - start) / 2;
 
        build(node * 2, start, mid, s);
        build(node * 2 + 1, mid + 1, end, s);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    public void update(int node, int start, int end, int index, char ch) {
        // update whole when the new one comes 
        if(start == end) {
            tree[node] = new Node(ch, ch, 1, 1, 1, 1);
            return;
        }

        int mid = start + ( end - start ) / 2;

        if(index <= mid) {
            // bs 
            update(node * 2, start, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, end, index, ch);      // prev error 
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }
}
}
