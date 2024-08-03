package io.github.tfreitasf.aluvery.ui.screens.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.tfreitasf.aluvery.database.dao.ProductDao
import io.github.tfreitasf.aluvery.database.model.Product
import io.github.tfreitasf.aluvery.database.model.sampleCandies
import io.github.tfreitasf.aluvery.database.model.sampleDrinks
import io.github.tfreitasf.aluvery.database.model.sampleProducts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val dao = ProductDao()

    private val sectionsFlow: Flow<Map<String, List<Product>>> = dao.getProducts().map { products ->
        mapOf(
            "Todos os Produtos" to products,
            "Promoções" to sampleDrinks + sampleCandies,
            "Doces" to sampleCandies,
            "Bebidas" to sampleDrinks
        )
    }

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            sectionsFlow.collect { sections ->
                _uiState.value = _uiState.value.copy(sections = sections)
            }
        }
    }

    private val _navigateToProductForm = MutableSharedFlow<Unit>()
    val navigateToProductForm: SharedFlow<Unit> = _navigateToProductForm


    fun updateSearchText(newText: String) {
        _uiState.value = _uiState.value.copy(searchText = newText)
        performSearch(newText)
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            val searchedProducts = if (query.isNotBlank()) {
                val sampleProductsFiltered = sampleProducts.filter(containsInNameOrDescription(query))
                val daoProductsFiltered = dao.getProducts().value.filter(containsInNameOrDescription(query))
                sampleProductsFiltered + daoProductsFiltered
            } else {
                emptyList()
            }
            _uiState.value = _uiState.value.copy(searchedProducts = searchedProducts)
        }
    }

    private fun containsInNameOrDescription(query: String) = { product: Product ->
        product.name.contains(query, ignoreCase = true) ||
                (product.description?.contains(query, ignoreCase = true) ?: false)
    }

    fun onFabClicked() {
        viewModelScope.launch {
            _navigateToProductForm.emit(Unit)
        }
    }
}