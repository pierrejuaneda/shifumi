package com.pjuaneda.shifumi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pjuaneda.shifumi.models.Choice
import com.pjuaneda.shifumi.models.Player
import com.pjuaneda.shifumi.models.match

class GameViewModel : ViewModel(){

    val first = MutableLiveData<Player>()
    val second = MutableLiveData<Player>()
    val winner = MutableLiveData<Player>()

    init {
        first.postValue(Player())
        second.postValue(Player())
    }

    fun play(choice: Choice){
        val firstPlayer = first.value ?: Player()
        val secondPlayer = second.value ?: Player()
        firstPlayer.choose(choice)
        secondPlayer.choose(Choice.randomValue())
        val win = firstPlayer.match(secondPlayer)
        winner.postValue(win)
        first.postValue(firstPlayer)
        second.postValue(secondPlayer)
    }
}