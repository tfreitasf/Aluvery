package io.github.tfreitasf.aluvery.ui.screens.productform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import io.github.tfreitasf.aluvery.R
import io.github.tfreitasf.aluvery.ui.screens.productform.viewmodel.ProductFormViewModel

@Composable
fun ProductFormScreen(viewModel: ProductFormViewModel, onSaveClick: () -> Unit = {}) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier)
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Criando o produto",
            fontSize = 28.sp,
            fontWeight = FontWeight(400),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if (uiState.productImageUrl.isNotEmpty()) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = uiState.productImageUrl,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.productImageUrl,
            maxLines = 1,
            onValueChange = { viewModel.updateProductImageUrl(it) },
            label = {
                Text(text = "Url da Imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.productName,
            maxLines = 1,
            onValueChange = { viewModel.updateProductName(it) },
            label = {
                Text(text = "Nome")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.productPrice,
            maxLines = 1,
            onValueChange = {
                val formattedInput = viewModel.formatPrice(it)
                viewModel.updateProductPrice(formattedInput)
            },
            label = {
                Text(text = "Preço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 250.dp),
            value = uiState.productDescription,
            maxLines = 5,
            onValueChange = { viewModel.updateProductDescription(it) },
            label = {
                Text(text = "Descrição")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Sentences
            ),
            keyboardActions = KeyboardActions(
                onDone = { onSaveClick() }
            )
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onSaveClick
        ) {
            Text(text = "Salvar")

        }
        Spacer(modifier = Modifier)
    }
}