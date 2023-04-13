package com.example.testing_laba3

// в качестве доски будет выстyпать 2-мерный массив 3х3 со значениями:
// 0 - пусто; 1 - крестик; 2 - нолик

enum class GameStatus {
    WINNER_X,
    WINNER_O,
    NO_WINNER,
    CONTINUE_GAME,
}

class GameEngine {
    private var playerX: Player? = null
    private var playerO: Player? = null

    var board = getEmptyBoard()

    fun checkGameOver(): GameStatus {
        //Смотрим победителя по строкам
        for (i in 0 until board.size) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return if (board[i][0] == x) GameStatus.WINNER_X else GameStatus.WINNER_O
            }
        }

        //Смотрим победителя по столбцам
        for (j in 0 until board[0].size) {
            if (board[0][j] != 0 && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return if (board[0][j] == x) GameStatus.WINNER_X else GameStatus.WINNER_O
            }
        }

        //Смотрим победителя главной диагонали
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return if (board[0][0] == x) GameStatus.WINNER_X else GameStatus.WINNER_O
        }

        //Смотрим победителя побочной диагонали
        if (board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return if (board[2][0] == x) GameStatus.WINNER_X else GameStatus.WINNER_O
        }

        if (board.any { it.contains(0) }) return GameStatus.CONTINUE_GAME

        return GameStatus.NO_WINNER
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