package com.atb.pokemon.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.atb.pokemon.R
import com.atb.pokemon.databinding.FragmentHomeBinding
import com.atb.pokemon.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

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

        lifecycleScope.launch {
            viewModel.uistate.collectLatest {
                Log.d(HomeFragment::class.java.simpleName, "$it")
            }
        }

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