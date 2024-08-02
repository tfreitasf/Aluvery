package io.github.tfreitasf.aluvery.ui.screens.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.tfreitasf.aluvery.model.sampleProducts
import io.github.tfreitasf.aluvery.model.sampleSections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(sections = sampleSections))
    val uiState: StateFlow<HomeUiState> = _uiState

    fun updateSearchText(newText: String) {
        _uiState.value = _uiState.value.copy(searchText = newText)
        performSearch(newText)
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            val searchedProducts = if (query.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(query, ignoreCase = true) ||
                            (product.description?.contains(query, ignoreCase = true)
                                ?: false)
                }
            } else {
                emptyList()
            }
            _uiState.value = _uiState.value.copy(searchedProducts = searchedProducts)
        }
    }
}