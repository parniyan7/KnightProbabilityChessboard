fun main(args: Array<String>) {
    val solution = Solution()
    val n = 3
    val k = 2
    val row = 0
    val column = 0
    val result = solution.knightProbability(n, k, row, column)
    println(result) // Output: 0.0625
}
class Solution {
    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {

        // Create a 3D array to store the probability of being at a certain cell after k moves
        val dp = Array(k + 1) { Array(n) { DoubleArray(n) } }

        // Initialize the probability of being at the starting cell to 1
        dp[0][row][column] = 1.0

        // Define the possible moves of the knight
        val moves = arrayOf(intArrayOf(2, 1), intArrayOf(1, 2), intArrayOf(-2, 1), intArrayOf(-1, 2), intArrayOf(2, -1), intArrayOf(1, -2), intArrayOf(-2, -1), intArrayOf(-1, -2))

        // Perform k moves
        for (step in 1..k) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    for (move in moves) {
                        val rowPrev = i - move[0]
                        val colPrev = j - move[1]

                        // Check if the previous position is within the board
                        if (rowPrev in 0 until n && colPrev in 0 until n) {
                            dp[step][i][j] += dp[step - 1][rowPrev][colPrev] / 8
                        }
                    }
                }
            }
        }

        // Calculate the probability of remaining on the board after k moves
        var probability = 0.0
        for (i in 0 until n) {
            for (j in 0 until n) {
                probability += dp[k][i][j]
            }
        }
        return probability
    }
}