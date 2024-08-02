package io.github.tfreitasf.aluvery.ui.screens.home.viewmodel

import io.github.tfreitasf.aluvery.model.Product

data class HomeUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchText: String = "",
    val searchedProducts: List<Product> = emptyList()
)