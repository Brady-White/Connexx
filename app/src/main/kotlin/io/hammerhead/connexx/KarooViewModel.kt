package io.hammerhead.connexx

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.hammerhead.karooext.KarooSystemService
import kotlinx.coroutines.launch

class KarooViewModel : ViewModel() {
    private var karooSystem: KarooSystemService? = null

    fun initialize(karooService: KarooSystemService) {
        karooSystem = karooService
        viewModelScope.launch {
            karooSystem?.connect {
                println("Karoo system connected")
            }
        }
    }

    override fun onCleared() {
        karooSystem?.disconnect()
        super.onCleared()
    }
}
