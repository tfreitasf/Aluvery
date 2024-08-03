package io.github.tfreitasf.aluvery.ui.screens.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import io.github.tfreitasf.aluvery.ui.screens.home.viewmodel.HomeViewModel
import io.github.tfreitasf.aluvery.ui.screens.productform.ProductFormActivity
import io.github.tfreitasf.aluvery.ui.theme.AluveryTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                HomeScreen(viewModel, onFabClick = { viewModel.onFabClicked() })
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.navigateToProductForm.collect {
                startActivity(Intent(this@HomeActivity, ProductFormActivity::class.java))
            }
        }
    }
}

