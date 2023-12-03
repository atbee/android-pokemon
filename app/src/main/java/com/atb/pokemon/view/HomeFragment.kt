package com.atb.pokemon.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atb.pokemon.PokemonCollectionActivity
import com.atb.pokemon.PokemonDetailActivity
import com.atb.pokemon.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private  lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokeball.setOnClickListener {
            val intent = Intent(activity, PokemonDetailActivity::class.java)
            intent.putExtra("Name", "Atb")
            startActivity(intent)
        }

        binding.backpack.setOnClickListener {
            val intent = Intent(activity, PokemonCollectionActivity::class.java)
            startActivity(intent)
        }
    }
}