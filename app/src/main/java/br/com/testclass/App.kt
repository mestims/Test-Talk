package br.com.testclass

import android.app.Application
import br.com.testclass.main.mainModule
import br.com.testclass.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, mainModule)
        }
    }
}