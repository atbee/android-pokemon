package com.atb.pokemon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.atb.pokemon.databinding.PokemonCardItemBinding
import com.atb.pokemon.model.Pokemon

class PokemonAdapter(
    private val pokemons: List<Pokemon>
): Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var view = PokemonCardItemBinding.inflate(inflater, parent, false)

        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }
}