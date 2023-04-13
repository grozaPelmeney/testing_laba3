package com.example.testing_laba3

class Player {
    var figure = 0

    fun canMakeMove(board: ArrayList<ArrayList<Int>>): Boolean {
        var canMakeMove = false
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                canMakeMove = board[i][j] == 0
                if (canMakeMove) break
            }
            if (canMakeMove) break
        }

        return canMakeMove
    }
}