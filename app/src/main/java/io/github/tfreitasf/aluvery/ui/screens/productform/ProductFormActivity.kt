package io.github.tfreitasf.aluvery.ui.screens.productform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.tfreitasf.aluvery.ui.screens.productform.viewmodel.ProductFormViewModel
import io.github.tfreitasf.aluvery.ui.theme.AluveryTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFormActivity : ComponentActivity() {
    private val viewModel: ProductFormViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                ProductFormScreen(viewModel)
            }
        }
    }
}