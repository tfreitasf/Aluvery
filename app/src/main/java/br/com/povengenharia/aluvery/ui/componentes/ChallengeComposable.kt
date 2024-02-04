package br.com.povengenharia.aluvery.ui.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.povengenharia.aluvery.R
import br.com.povengenharia.aluvery.ui.theme.Purple500
import br.com.povengenharia.aluvery.ui.theme.Teal200


@Composable
fun ChallengeComposableHorizontal() {
    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp
    ) {
        val imageSize = 100.dp
        Row(
            Modifier
                .height(imageSize * 2)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Teal200,
                                Purple500
                            )
                        )
                    )
                    .width(imageSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(
                        R.string.product_item_cd_image_description
                    ),
                    Modifier
                        .size(imageSize)
                        .align(Alignment.Center)
                        .offset(x = imageSize / 2)
                        .clip(shape = CircleShape)
                        .border(
                            BorderStroke(
                                2.dp, brush = Brush.verticalGradient(
                                    listOf(
                                        Purple500,
                                        Teal200
                                    )
                                )
                            ), CircleShape
                        )
                )
            }
            Spacer(Modifier.width(imageSize / 2))
            Box(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .padding(16.dp)
                    .align(CenterVertically),
            ) {
                Column {
                    Text(
                        text = LoremIpsum(50).values.first(),
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}
@Composable
fun ChallengeComposableVertical(description: String = "") {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500,
                                Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(
                        R.string.product_item_cd_image_description
                    ),
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "R$ 14,99",
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            if(description.isNotBlank()){
                Text(
                    text = description,
                    Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp,
                            top = 8.dp
                        ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview
@Composable
fun ChallengeComposableVerticalPreview() {
    ChallengeComposableVertical()
}

@Preview
@Composable
fun ChallengeComposableDescriptionPreview() {
    ChallengeComposableVertical(LoremIpsum(50).values.first())
    
}

@Preview
@Composable
fun ChallengeComposableHorizontalPreview() {
    ChallengeComposableHorizontal()

}