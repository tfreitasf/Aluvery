package io.github.tfreitasf.aluvery.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.tfreitasf.aluvery.ui.components.CardProductItem
import io.github.tfreitasf.aluvery.ui.components.ProductSection
import io.github.tfreitasf.aluvery.ui.components.SearchTextField
import io.github.tfreitasf.aluvery.ui.screens.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onFabClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Produto")
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column {
                SearchTextField(
                    searchText = uiState.searchText,
                    onSearchTextChange = { viewModel.updateSearchText(it) })
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    if (uiState.searchText.isBlank()) {
                        uiState.sections.forEach { (title, products) ->
                            item {
                                ProductSection(
                                    title = title,
                                    products = products
                                )
                            }
                        }
                    } else {
                        items(uiState.searchedProducts) { product ->
                            CardProductItem(
                                product = product,
                                Modifier.padding(horizontal = 16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    val homeViewModel = HomeViewModel()
    HomeScreen(homeViewModel)
}