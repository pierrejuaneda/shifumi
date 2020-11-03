package com.pjuaneda.shifumi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pjuaneda.shifumi.models.Choice
import com.pjuaneda.shifumi.models.Player

/**
 * A simple [Fragment] to play Shifumi game.
 */
class GameFragment : Fragment() {

    private val gameVM = GameViewModel()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addObservers()

        view.findViewById<ImageButton>(R.id.game_toolbar_go_back).setOnClickListener {
            findNavController().navigate(R.id.action_game_back_to_home)
            findNavController().popBackStack()
        }

        view.findViewById<ImageButton>(R.id.game_play_rock).setOnClickListener {
            gameVM.play(Choice.ROCK)
        }
        view.findViewById<ImageButton>(R.id.game_play_paper).setOnClickListener {
            gameVM.play(Choice.PAPER)
        }

        view.findViewById<ImageButton>(R.id.game_play_scissors).setOnClickListener {
            gameVM.play(Choice.SCISSORS)
        }
    }

    private fun addObservers() {
        gameVM.first.observe(viewLifecycleOwner, Observer<Player> {
            view?.findViewById<ImageView>(R.id.game_hand_first)?.setImageDrawable(
                when (it.choice) {
                    Choice.PAPER -> ContextCompat.getDrawable(requireContext(), R.drawable.ic_paper)
                    Choice.ROCK -> ContextCompat.getDrawable(requireContext(), R.drawable.ic_rock)
                    Choice.SCISSORS -> ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_scissors
                    )
                    null -> null
                }
            )
            view?.findViewById<TextView>(R.id.game_score_first)?.text = it.score.toString()
        })

        gameVM.second.observe(viewLifecycleOwner, Observer<Player> {
            view?.findViewById<ImageView>(R.id.game_hand_second)?.setImageDrawable(
                when (it.choice) {
                    Choice.PAPER -> ContextCompat.getDrawable(requireContext(), R.drawable.ic_paper)
                    Choice.ROCK -> ContextCompat.getDrawable(requireContext(), R.drawable.ic_rock)
                    Choice.SCISSORS -> ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_scissors
                    )
                    null -> null
                }
            )
            view?.findViewById<TextView>(R.id.game_score_second)?.text = it.score.toString()

        })
    }
}