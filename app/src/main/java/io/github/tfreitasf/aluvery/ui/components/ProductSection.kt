package io.github.tfreitasf.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.tfreitasf.aluvery.model.Product
import io.github.tfreitasf.aluvery.model.sampleProducts
import io.github.tfreitasf.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductSection(
    title: String,
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)

        )
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }
}

@Preview
@Composable
private fun ProductSectionPreview() {
    AluveryTheme {
        ProductSection("Promoções", products = sampleProducts)
    }
}

