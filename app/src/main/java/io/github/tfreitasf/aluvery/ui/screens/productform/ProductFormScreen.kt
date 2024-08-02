package io.github.tfreitasf.aluvery.ui.screens.productform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.tfreitasf.aluvery.ui.screens.productform.viewmodel.ProductFormViewModel

@Composable
fun ProductFormScreen(viewModel: ProductFormViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Criando o produto",
            fontSize = 28.sp,
            fontWeight = FontWeight(400),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.productImageUrl,
            onValueChange = {viewModel.updateProductImageUrl(it)},
            label = {
                Text(text = "Url da Imagem")
            }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.productName,
            onValueChange = {viewModel.updateProductName(it)},
            label = {
                Text(text = "Nome")
            }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.productPrice,
            onValueChange = {viewModel.updateProductPrice(it)},
            label = {
                Text(text = "Preço")
            }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 250.dp),
            value = uiState.productDescription.toString(),
            onValueChange = {viewModel.updateProductDescription(it)},
            label = {
                Text(text = "Descrição")
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { /*TODO*/ }) {
            Text(text = "Salvar")

        }
    }

}