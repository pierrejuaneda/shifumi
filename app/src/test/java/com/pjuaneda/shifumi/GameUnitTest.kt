package com.pjuaneda.shifumi

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameUnitTest {

    lateinit var first: Player
    lateinit var second: Player

    @Before
    internal fun setUp() {
        first = Player()
        second = Player()
    }

    @Test
    // Tests if a choice is applied to the player
    internal fun testChoose() {
        first.choose(Choice.ROCK)
        assert(first.choice == Choice.ROCK)
    }

    // Match test
    @Test
    // Tests if two player matching with the same choice end up with no winner
    internal fun testTie() {
        first.choose(Choice.ROCK)
        second.choose(Choice.ROCK)
        val result = first.match(second)
        assert(result == null)
    }

    @Test
    // Tests if a player wins end up as winner
    internal fun testFirstWin() {
        first.choose(Choice.PAPER)
        second.choose(Choice.ROCK)
        val result = first.match(second)
        assert(result == first)
    }

    @Test
    // Tests if a player loose does not end up as winner
    internal fun testFirstLoose() {
        first.choose(Choice.PAPER)
        second.choose(Choice.SCISSORS)
        val result = first.match(second)
        assert(result != first)
        assert(result == second)
    }

    // Score Test
    @Test
    // Tests if winning increment the winner's score
    fun testWinningIncrementScore() {
        first.choose(Choice.PAPER)
        second.choose(Choice.SCISSORS)

        // Checking if Scores were initialised to 0
        Assert.assertEquals(first.score, 0)
        Assert.assertEquals(second.score, 0)

        // Checking if a win increases second's score
        first.match(second)
        Assert.assertEquals(first.score, 0)
        Assert.assertEquals(second.score, 1)
    }

    @Test
    // Tests if a tie does not increment anyone score
    fun testTieDoesNotIncrementScore() {
        first.chooseHand(Choice.PAPER)
        second.chooseHand(Choice.PAPER)

        // Checking if Scores were initialised to 0
        Assert.assertEquals(first.score, 0)
        Assert.assertEquals(second.score, 0)

        first.match(second)
        // Checking if ties does not impact the score
        Assert.assertEquals(first.score, 0)
        Assert.assertEquals(second.score, 0)
    }

}