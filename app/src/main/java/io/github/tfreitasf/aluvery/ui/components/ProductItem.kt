package io.github.tfreitasf.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import io.github.tfreitasf.aluvery.R
import io.github.tfreitasf.aluvery.extensions.toBrazilianCurrency
import io.github.tfreitasf.aluvery.model.Product
import io.github.tfreitasf.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .heightIn(min = 250.dp, max = 300.dp)
                .width(200.dp)
                .background(Color.White)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary

                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = 50.dp)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = product.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}


@Preview
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        ProductItem(
            Product(
                name = LoremIpsum(50).values.first(),
                price = BigDecimal("14.99")
            )
        )
    }
}