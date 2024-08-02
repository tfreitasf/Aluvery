package io.github.tfreitasf.aluvery.ui.screens.productform.viewmodel

data class ProductFormUIState(
    val productImageUrl: String = "",
    val productName: String = "",
    val productPrice: String = "",
    val productDescription: String? = null,
)