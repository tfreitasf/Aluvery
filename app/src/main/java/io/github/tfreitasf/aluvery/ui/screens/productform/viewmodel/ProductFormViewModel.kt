package io.github.tfreitasf.aluvery.ui.screens.productform.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductFormViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(ProductFormUIState())
    val uiState: StateFlow<ProductFormUIState> = _uiState

    fun updateProductImageUrl(newUrl: String){
        _uiState.value = _uiState.value.copy(productImageUrl = newUrl)
    }

    fun updateProductName(newName: String) {
        _uiState.value = _uiState.value.copy(productName = newName)
    }

    fun updateProductPrice(newPrice: String) {
        _uiState.value = _uiState.value.copy(productPrice = newPrice)
    }

    fun updateProductDescription(newDescription: String) {
        _uiState.value = _uiState.value.copy(productDescription = newDescription)
    }
}