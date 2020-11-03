package com.pjuaneda.shifumi.models

enum class Choice {
    ROCK,
    PAPER,
    SCISSORS;

    companion object {
        fun randomValue() = values().random()
    }
}
