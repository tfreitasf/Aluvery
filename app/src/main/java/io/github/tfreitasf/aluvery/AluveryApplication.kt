package io.github.tfreitasf.aluvery

import android.app.Application
import io.github.tfreitasf.aluvery.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AluveryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AluveryApplication)
            modules(viewModelModule)
        }
    }
}