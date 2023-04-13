package com.example.testing_laba3

// в качестве доски будет выстyпать 2-мерный массив 3х3 со значениями:
// 0 - пусто; 1 - крестик; 2 - нолик

class GameEngine {
    private var playerX: Player? = null
    private var playerO: Player? = null

    var board = getEmptyBoard()

    fun checkGameOver(): Int {
        //Смотрим победителя по строкам
        for (i in 0 until board.size) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0]
            }
        }

        //Смотрим победителя по столбцам
        for (j in 0 until board[0].size) {
            if (board[0][j] != 0 && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j]
            }
        }

        //Смотрим победителя главной диагонали
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0]
        }

        //Смотрим победителя побочной диагонали
        if (board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return board[2][0]
        }

        return 0
    }

    fun createPlayerX(): Player {
        playerX = Player().apply { figure = x }
        return playerX!!
    }

    fun createPlayerO(): Player {
        playerO = Player().apply { figure = o }
        return playerO!!
    }

    companion object {
        const val x = 1
        const val o = 2

        fun getEmptyBoard(): ArrayList<ArrayList<Int>> {
            return arrayListOf(
                arrayListOf(0, 0, 0),
                arrayListOf(0, 0, 0),
                arrayListOf(0, 0, 0)
            )
        }
    }
}