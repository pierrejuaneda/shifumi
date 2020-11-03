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

        arguments?.getBoolean("isPlayer")?.let {
            view.findViewById<ImageButton>(R.id.game_play_rock).visibility = if(it) View.VISIBLE else View.GONE
            view.findViewById<ImageButton>(R.id.game_play_paper).visibility = if(it) View.VISIBLE else View.GONE
            view.findViewById<ImageButton>(R.id.game_play_scissors).visibility = if(it) View.VISIBLE else View.GONE
            view.findViewById<Button>(R.id.game_play_computer).visibility = if(it) View.GONE else View.VISIBLE
            view.findViewById<TextView>(R.id.game_actions_title).visibility = if(it) View.VISIBLE else View.GONE
            view.findViewById<TextView>(R.id.game_scores_first_title).text = if(it) getString(R.string.game_player) else getText(R.string.game_computer)
        }

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
        view.findViewById<Button>(R.id.game_play_computer).setOnClickListener {
            gameVM.play(Choice.randomValue())
        }
    }

    private fun addObservers() {
        gameVM.first.observe(viewLifecycleOwner, Observer<Player> {
            view?.findViewById<ImageView>(R.id.game_hand_first)?.setChoice(it.choice)
            view?.findViewById<TextView>(R.id.game_score_first)?.text = it.score.toString()
        })

        gameVM.second.observe(viewLifecycleOwner, Observer<Player> {
            view?.findViewById<ImageView>(R.id.game_hand_second)?.setChoice(it.choice)
            view?.findViewById<TextView>(R.id.game_score_second)?.text = it.score.toString()
        })
    }

    private fun ImageView.setChoice(choice: Choice?){
        when(choice){
            Choice.PAPER -> {
                setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_paper))
                contentDescription = getString(R.string.game_actions_paper_content)
            }
            Choice.ROCK -> {
                setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_rock))
                contentDescription = getString(R.string.game_actions_rock_content)
            }
            Choice.SCISSORS -> {
                setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_scissors))
                contentDescription = getString(R.string.game_actions_scissors_content)
            }
            null -> {
                setImageDrawable(null)
                contentDescription = null
            }
        }
    }
}