package io.github.tfreitasf.aluvery.ui.screens.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.tfreitasf.aluvery.ui.screens.home.viewmodel.HomeViewModel
import io.github.tfreitasf.aluvery.ui.theme.AluveryTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                HomeScreen(
                    viewModel
                )
            }
        }
    }
}

