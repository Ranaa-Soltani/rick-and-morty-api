package org.mathieu.cleanrmapi

import android.app.Application
import org.koin.android.ext.koin.androidContext

class CleanRmApiApplication : Application() {

    companion object {
        lateinit var instance: CleanRmApiApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@CleanRmApiApplication)
        }

        instance = this
    }
}
