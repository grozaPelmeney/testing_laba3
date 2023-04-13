package com.example.testing_laba3

class Player {
    var figure = 0

    fun canMakeMove(board: ArrayList<ArrayList<Int>>): Pair<Int, Int>? {
        var pos: Pair<Int, Int>? = null

        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j] == 0) {
                    pos = Pair(i, j)
                    break
                }
            }
            if (pos != null) break
        }

        return pos
    }

    fun makeMove(pos: Pair<Int, Int>, board: ArrayList<ArrayList<Int>>) {
        board[pos.first][pos.second] = figure
    }
}