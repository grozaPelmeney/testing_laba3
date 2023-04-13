package com.example.testing_laba3

class Player {
    var figure = 0

    fun canMakeMove(board: ArrayList<ArrayList<Int>>): Pair<Int, Int>? {
        val emptyFields = mutableListOf<Pair<Int, Int>>()

        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j] == 0) {
                    emptyFields.add(Pair(i, j))
                }
            }
        }

        return if (emptyFields.isEmpty()) null else emptyFields.random()
    }

    fun makeMove(pos: Pair<Int, Int>, board: ArrayList<ArrayList<Int>>) {
        board[pos.first][pos.second] = figure
    }
}