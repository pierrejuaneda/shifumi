package com.pjuaneda.shifumi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pjuaneda.shifumi.models.Choice
import com.pjuaneda.shifumi.models.Player
import com.pjuaneda.shifumi.models.match

class GameViewModel : ViewModel(){

    val first = MutableLiveData<Player>()
    val second = MutableLiveData<Player>()

    init {
        first.postValue(Player())
        second.postValue(Player())
    }

    // Play a match against a computer with a defined Choice
    fun play(choice: Choice){
        // Set Choices
        val firstPlayer = first.value ?: Player()
        val secondPlayer = second.value ?: Player()
        firstPlayer.choose(choice)
        secondPlayer.choose(Choice.randomValue())

        // Matching
        firstPlayer.match(secondPlayer)

        // Post Values to update UI
        first.postValue(firstPlayer)
        second.postValue(secondPlayer)
    }
}