package com.example.testing_laba3

// в качестве доски будет выстyпать 2-мерный массив 3х3 со значениями:
// 0 - пусто; 1 - крестик; 2 - нолик

class GameEngine {

    companion object {
        fun getEmptyBoard(): ArrayList<ArrayList<Int>> {
            return arrayListOf(
                arrayListOf(0, 0, 0),
                arrayListOf(0, 0, 0),
                arrayListOf(0, 0, 0)
            )
        }
    }
}