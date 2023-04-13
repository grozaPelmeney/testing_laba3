package com.example.testing_laba3

import junit.framework.TestCase.assertEquals
import org.junit.Test

class GameTest {
    //Тест для проверки, может ли игрок сделать ход
    @Test
    fun `check player can make move`() {
        val x = 1
        val o = 2

        val board = GameEngine.getEmptyBoard()
        val player = Player()

        val expected = true
        val actual = player.canMakeMove(board)

        assertEquals(expected, actual)
    }
}