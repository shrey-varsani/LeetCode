package org.shrey.dsa.leetcode.august;

/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.
*/
public class StoneGame4 {
    public boolean winnerSquareGame(int n) {
        Boolean[] res = new Boolean[n + 1];     // for 0's case 

        return solver(n, res);
    }

    public boolean solver(int rem, Boolean[] res) {   // rem => remaining stones in current one's turn
        if(res[rem] != null) return res[rem];

        // remove 1 => perfect square number
        for(int i=1; i*i<=rem; i++) {
            int nextRemoval = i * i;

            // can remove nextRemoval stones

            // can that make opponent loose the game
            if(!solver(rem - nextRemoval, res)) {       // opponent will get the remaining stones
                return res[rem] = true;
            }
        }

        return res[rem] = false;
    }
}
