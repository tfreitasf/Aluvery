package br.com.povengenharia.aluvery.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.povengenharia.aluvery.ui.theme.AluveryTheme

@Composable
fun MyFirstComposable() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        Text(text = "My First Composable")
        Text(text = "My Second Composable")
    }
}

@Preview(showBackground = true)
@Composable
fun CustomLayoutPreview() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
            .padding(all = 16.dp)
            .background(color = Color.Red)
            .fillMaxHeight()

    ) {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 16.dp
                )
                .background(Color.Green)
                .fillMaxWidth(0.5f)
        ) {
            Text(text = "Texto 3")
            Text(text = "Texto 4")
        }
        Box(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 16.dp
                )
                .background(Color.Cyan)

        ) {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 16.dp
                    )
                    .background(Color.Magenta)
                    .fillMaxWidth()
            ) {
                Text(text = "Texto 5")
                Text(text = "Texto 6")
            }
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 16.dp
                    )
                    .background(Color.Yellow)
            ) {
                Text(text = "Texto 7")
                Text(text = "Texto 8")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Column {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }

}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    Box {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }

}

@Preview
@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }

    }

}