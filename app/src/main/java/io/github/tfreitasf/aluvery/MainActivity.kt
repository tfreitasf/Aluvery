package io.github.tfreitasf.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.tfreitasf.aluvery.sampledata.sampleSections
import io.github.tfreitasf.aluvery.ui.screens.HomeScreen
import io.github.tfreitasf.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                HomeScreen(
                    sampleSections
                )
            }
        }
    }
}

