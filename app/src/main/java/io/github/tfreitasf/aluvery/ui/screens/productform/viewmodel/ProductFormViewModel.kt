package io.github.tfreitasf.aluvery.ui.screens.productform.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.tfreitasf.aluvery.database.dao.ProductDao
import io.github.tfreitasf.aluvery.database.model.Product
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProductFormUIState())
    val uiState: StateFlow<ProductFormUIState> = _uiState

    private val _productSavedEvent = MutableSharedFlow<Unit>()
    val productSavedEvent: SharedFlow<Unit> = _productSavedEvent

    private val priceFormatter = DecimalFormat("#.##")

    fun updateProductImageUrl(newUrl: String) {
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

    fun formatPrice(price: String): String {
        return try {
            val bigDecimalPrice = BigDecimal(price)
            priceFormatter.format(bigDecimalPrice)
        } catch (e: NumberFormatException) {
            ""
        }
    }

    fun onClickCreateNewProduct() {
        val formattedPrice = try {
            BigDecimal(_uiState.value.productPrice)
        } catch (e: NumberFormatException) {
            BigDecimal.ZERO
        }
        val newProduct = Product(
            name = _uiState.value.productName,
            price = formattedPrice,
            image = _uiState.value.productImageUrl,
            description = _uiState.value.productDescription
        )
        createNewProduct(newProduct)
    }

    private fun createNewProduct(product: Product) {
        viewModelScope.launch {
            val dao = ProductDao()
            dao.addProduct(product)
            _productSavedEvent.emit(Unit)
        }
    }
}