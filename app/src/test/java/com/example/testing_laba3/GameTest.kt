package com.example.testing_laba3

import junit.framework.TestCase.assertEquals
import org.junit.Test

class GameTest {
    private val x = 1
    private val o = 2

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
}