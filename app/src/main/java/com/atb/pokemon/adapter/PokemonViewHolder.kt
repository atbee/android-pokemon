package com.atb.pokemon.adapter

import androidx.recyclerview.widget.RecyclerView
import com.atb.pokemon.databinding.ActivityPokemonDetailBinding
import com.atb.pokemon.databinding.PokemonCardItemBinding
import com.atb.pokemon.model.Pokemon

class PokemonViewHolder(
    private val binding: PokemonCardItemBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(pokemon: Pokemon) {
        binding.pokemonNameTv.text = pokemon.name.english
        binding.pokemonTypeTv.text = pokemon.types.joinToString(", ")
    }
}