# Knight Probability Chessboard

This is a solution for the Knight Probability Chessboard problem implemented in Kotlin. The problem statement is as follows:

On an `n x n` chessboard, a knight starts at the cell `(row, column)` and attempts to make exactly `k` moves. The probability of each valid move is `1/8`. The knight can move to any cell on the standard chessboard if it is not outside the board.

Return the probability that the knight remains on the board after it has stopped moving.

## Solution

The solution uses dynamic programming to calculate the probability of being at a certain cell after `k` moves. We create a 3D array `dp` of size `(k+1) x n x n`, where `dp[i][j][k]` represents the probability of being at cell `(j, k)` after `i` moves. We initialize `dp[0][row][column]` to 1, since the probability of being at the starting cell after 0 moves is 1.

We define the possible moves of the knight and iterate through all the cells on the board, calculating the probability of being at the current cell after `i` moves, based on the probability of being at the previous cells. We add up the probabilities for all the possible previous cells and divide by 8, since the probability of each valid move is `1/8`. We do this for each possible move and add up the probabilities for all the previous cells to get the probability of being at the current cell after `i` moves.

After `k` moves, we sum up the probabilities for all the cells on the board to get the probability of remaining on the board after `k` moves.

## Usage

To use this solution, create an instance of the `Solution` class and call the `knightProbability` method, passing in the `n`, `k`, `row`, and `column` as parameters.

```kotlin
val solution = Solution()
val n = 3
val k = 2
val row = 0
val column = 0
val result = solution.knightProbability(n, k, row, column)
println(result) // Output: 0.0625
```

In this example, a knight starts at cell `(0, 0)` on a `3 x 3` chessboard and makes exactly `2` moves. The probability of remaining on the board after `2` moves is `0.0625`.
