package com.booknara.problem.array;

/**
 * 2660. Determine the Winner of a Bowling Game (Easy)
 * https://leetcode.com/problems/determine-the-winner-of-a-bowling-game
 */
public class DetermineTheWinnerOfBowlingGame {
  // T:O(n), S:O(1)
  public int isWinner(int[] player1, int[] player2) {
    int player1Score = getScore(player1);
    int player2Score = getScore(player2);
    if (player1Score == player2Score) {
      return 0;
    }

    return player1Score > player2Score ? 1 : 2;
  }

  public int getScore(int[] player) {
    int score = 0;
    for (int i = 0; i < player.length; i++) {
      if (i - 2 >= 0 && player[i - 2] == 10) {
        score += 2 * player[i];
      } else if (i - 1 >= 0 && player[i - 1] == 10) {
        score += 2 * player[i];
      } else {
        score += player[i];
      }
    }

    return score;
  }
}
