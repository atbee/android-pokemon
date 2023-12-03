package com.atb.pokemon.repository

import com.atb.pokemon.api.PokemonApi
import com.atb.pokemon.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

interface PokemonRepository {
    suspend fun getPokemonList(): Flow<Pokemon>
}

class PokemonRepositoryImp @Inject constructor(
    private val pokemonApi: PokemonApi
): PokemonRepository {
    override suspend fun getPokemonList(): Flow<Pokemon> {
        val response = pokemonApi.getPokemonList()
        return if (response.isSuccessful) {
            val pokemon = response.body()?.random()
            if (pokemon == null) {
                flow<Pokemon> { throw Exception() }
            } else {
                flow { emit(pokemon) }
            }
        } else {
            flow<Pokemon> { throw Exception() }
        }
    }
}