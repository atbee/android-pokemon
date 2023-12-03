package com.atb.pokemon.di

import com.atb.pokemon.api.PokemonApi
import com.atb.pokemon.repository.PokemonRepository
import com.atb.pokemon.repository.PokemonRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun providePokemonRepository(pokemonApi: PokemonApi): PokemonRepository = PokemonRepositoryImp(pokemonApi)
}