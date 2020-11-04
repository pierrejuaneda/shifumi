package com.pjuaneda.shifumi.models

data class Player (var choice: Choice? = null, var score: Int = 0) {
    // Set a choice to a player
    fun choose(choice: Choice){
        this.choice = choice
    }

    // Increment score by one
    fun incrementScore(){
        this.score += 1
    }
}

// Matching a player against another, increase the score of the winner if there's one and return it
fun Player.match(opponent: Player): Player?{
    val winner = when(this.choice){
        Choice.PAPER ->
            when(opponent.choice){
                // Win Case
                Choice.ROCK -> this
                // Loose Case
                Choice.SCISSORS -> opponent
                // Tie Case
                Choice.PAPER, null -> null
            }
        Choice.ROCK -> when(opponent.choice){
            // Win Case
            Choice.SCISSORS -> this
            // Loose Case
            Choice.PAPER -> opponent
            // Tie Case
            Choice.ROCK, null -> null
        }
        Choice.SCISSORS -> when(opponent.choice){
            // Win Case
            Choice.PAPER -> this
            // Loose Case
            Choice.ROCK -> opponent
            // Tie Case
            Choice.SCISSORS, null -> null
        }
        null -> null
    }
    // Increment score
    winner?.incrementScore()
    return winner
}