

import java.util.*;

class Solution {
    int n;
    int MOD = 1_000_000_007;

    private int getIntFromChar(char ch) {
        return ch == 'S' || ch == 'E' ? 0 : ch - '0';
    }

    private boolean isValid(int i, int j, List<String> board) {
        return i >= 0 && i < n && j >= 0 && j < n
               && board.get(i).charAt(j) != 'X';
    }

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();

        int[][] tScore = new int[n][n];
        int[][] tPaths = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(tScore[i], -1);
        }

        tScore[0][0] = 0;
        tPaths[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                char ch = board.get(i).charAt(j);

                if (ch == 'E' || ch == 'X') continue;

                int upScore = -1, upPaths = 0;
                int leftScore = -1, leftPaths = 0;
                int diagScore = -1, diagPaths = 0;

                if (isValid(i - 1, j, board)) {
                    upScore = tScore[i - 1][j];
                    upPaths = tPaths[i - 1][j];
                }

                if (isValid(i, j - 1, board)) {
                    leftScore = tScore[i][j - 1];
                    leftPaths = tPaths[i][j - 1];
                }

                if (isValid(i - 1, j - 1, board)) {
                    diagScore = tScore[i - 1][j - 1];
                    diagPaths = tPaths[i - 1][j - 1];
                }

                int bestScore = -1;
                long bestPaths = 0;

                if (upScore != -1) {
                    bestScore = upScore;
                    bestPaths = upPaths;
                }

                if (leftScore != -1) {
                    if (leftScore > bestScore) {
                        bestScore = leftScore;
                        bestPaths = leftPaths;
                    } else if (leftScore == bestScore) {
                        bestPaths += leftPaths;
                    }
                }

                if (diagScore != -1) {
                    if (diagScore > bestScore) {
                        bestScore = diagScore;
                        bestPaths = diagPaths;
                    } else if (diagScore == bestScore) {
                        bestPaths += diagPaths;
                    }
                }

                if (bestScore == -1) continue;

                tScore[i][j] = bestScore + getIntFromChar(ch);
                tPaths[i][j] = (int)(bestPaths % MOD);
            }
        }

        if (tScore[n - 1][n - 1] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{
            tScore[n - 1][n - 1],
            tPaths[n - 1][n - 1]
        };
    }
}

//The biggest takeaway: Never use a modulo-based count to determine whether a DP state is reachable. Use a separate validity marker or a suitable sentinel in your DP state.
// i hv initialized if upscore>0 ..... leftscore>0 .... etc etc but vo modulo ke baad 0 ho jayegi to rather initialize upcore!=-1. leftscore!=-1 etc etc

//MST IMP CHANGE REVISION KE TIME PAR REMMEBERRRR
