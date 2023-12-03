package com.atb.pokemon.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atb.pokemon.api.PokemonApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonApi: PokemonApi
) : ViewModel() {
    fun getPokemonList() {
        Log.d("EYE" , "BEFORE SCOPE")
        viewModelScope.launch {
            val list = pokemonApi.getPokemonList()
            Log.d("EYE" , "GOT LIST")
        }
        Log.d("EYE" , "OUT OF SCOPE")
    }
}