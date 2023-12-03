package com.atb.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.atb.pokemon.adapter.PokemonAdapter
import com.atb.pokemon.databinding.ActivityPokemonCollectionBinding
import com.atb.pokemon.model.mockPokemonList
import java.util.zip.Inflater

class PokemonCollectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonCollectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PokemonAdapter(mockPokemonList())
        binding.pokemonRv.adapter = adapter
    }
}