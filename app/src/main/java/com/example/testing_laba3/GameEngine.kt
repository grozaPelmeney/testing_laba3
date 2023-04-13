package com.example.testing_laba3

// в качестве доски будет выстyпать 2-мерный массив 3х3 со значениями:
// 0 - пусто; 1 - крестик; 2 - нолик

class GameEngine {
    private var playerX: Player? = null
    private var playerO: Player? = null

    var board = getEmptyBoard()

    fun checkGameOver(): Int {
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