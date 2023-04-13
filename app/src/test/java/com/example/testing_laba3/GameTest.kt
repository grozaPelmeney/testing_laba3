package com.example.testing_laba3

import junit.framework.TestCase.assertEquals
import org.junit.Test

class GameTest {
    private val x = GameEngine.x
    private val o = GameEngine.o

    //Тесты для проверки, может ли игрок сделать ход
    @Test
    fun `check player can make move in empty board`() {
        val board = GameEngine.getEmptyBoard()

        val player = Player()

        val expected = Pair(0, 0)
        val actual = player.canMakeMove(board)

        assertEquals(expected, actual)
    }

    @Test
    fun `check player can make move in part filled board`() {
        val board = arrayListOf(
            arrayListOf(x, o, o),
            arrayListOf(o, o, x),
            arrayListOf(x, 0, x)
        )

        val player = Player()

        val expected = Pair(2, 1)
        val actual = player.canMakeMove(board)

        assertEquals(expected, actual)
    }

    @Test
    fun `check player can make move in filled board`() {
        val board = arrayListOf(
            arrayListOf(x, o, o),
            arrayListOf(o, o, x),
            arrayListOf(x, x, o)
        )

        val player = Player()

        val expected = null
        val actual = player.canMakeMove(board)

        assertEquals(expected, actual)
    }

    //Тест для создания игроков
    @Test
    fun `check creating players`() {
        val engine = GameEngine()

        val pX = engine.createPlayerX()
        val pO = engine.createPlayerO()

        val expected = true
        val actual = pX.figure == x && pO.figure == o

        assertEquals(expected, actual)
    }

    //Тест для првоерки окончания игры
    @Test
    fun `check game is over`() {
        val engine = GameEngine()

        val boards =
            listOf(
                arrayListOf( //выиграл х по 1 строке
                    arrayListOf(x, x, x),
                    arrayListOf(o, o, x),
                    arrayListOf(x, x, o)
                ),
                arrayListOf( //выиграл о по 2 столбцу
                    arrayListOf(x, o, x),
                    arrayListOf(o, o, x),
                    arrayListOf(x, o, o)
                ),
                arrayListOf( //выиграл х по побочной диагонали
                    arrayListOf(x, o, x),
                    arrayListOf(o, x, x),
                    arrayListOf(x, o, o)
                ),
                arrayListOf( //выиграл о по главной диагонали
                    arrayListOf(o, x, x),
                    arrayListOf(o, o, x),
                    arrayListOf(x, o, o)
                ),
                arrayListOf( //игра не окончена
                    arrayListOf(x, x, 0),
                    arrayListOf(o, 0, x),
                    arrayListOf(0, 0, o)
                ),
                arrayListOf( //нет победителя
                    arrayListOf(x, x, o),
                    arrayListOf(o, o, x),
                    arrayListOf(x, o, o)
                ),
            )

        val res = mutableListOf<Int>() //массив результатов

        boards.forEach { board ->
            engine.board = board
            res.add(engine.checkGameOver())
        }

        val expected = listOf(
            GameStatus.WINNER_X, GameStatus.WINNER_O, GameStatus.WINNER_X,
            GameStatus.WINNER_O, GameStatus.CONTINUE_GAME, GameStatus.NO_WINNER
        )
        val actual = res.toList()

        assertEquals(expected, actual)
    }
}