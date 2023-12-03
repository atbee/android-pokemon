package com.atb.pokemon.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.atb.pokemon.PokemonCollectionActivity
import com.atb.pokemon.PokemonDetailActivity
import com.atb.pokemon.R
import com.atb.pokemon.databinding.FragmentHomeBinding
import com.atb.pokemon.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  lateinit var binding: FragmentHomeBinding

    val viewModel: HomeViewModel by viewModels()
//    val viewModel: HomeViewModel by activityViewModels() // Depends on activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokeball.setOnClickListener {
            viewModel.getPokemonList()
            val action = R.id.action_homeFragment_to_pokemonDetailFragment
            findNavController().navigate(action)
        }

        binding.backpack.setOnClickListener {
            val action = R.id.action_homeFragment_to_pokemonCollectionFragment
            findNavController().navigate(action)
        }
    }
}