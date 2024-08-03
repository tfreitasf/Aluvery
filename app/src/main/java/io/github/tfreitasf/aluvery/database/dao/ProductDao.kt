package io.github.tfreitasf.aluvery.database.dao

import io.github.tfreitasf.aluvery.database.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductDao {
    companion object {
        private val _products = MutableStateFlow<List<Product>>(emptyList())
        val products: StateFlow<List<Product>> = _products
    }

    fun getProducts(): StateFlow<List<Product>> {
        return products
    }

    fun addProduct(product: Product) {
        val currentProducts = _products.value.toMutableList()
        currentProducts.add(product)
        _products.value = currentProducts
    }
}