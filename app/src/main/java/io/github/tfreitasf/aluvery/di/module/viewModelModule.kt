package io.github.tfreitasf.aluvery.di.module

import io.github.tfreitasf.aluvery.ui.screens.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel()
    }
}