package com.pjuaneda.shifumi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

/**
 * A simple home [Fragment].
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.home_play_human).setOnClickListener {
            val bundle = bundleOf("isPlayer" to true)
            findNavController().navigate(R.id.action_home_to_game, bundle)
        }

        view.findViewById<Button>(R.id.home_play_computer).setOnClickListener {
            val bundle = bundleOf("isPlayer" to false)
            findNavController().navigate(R.id.action_home_to_game, bundle)
        }
    }
}