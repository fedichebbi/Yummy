package com.example.yummy

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class ForecastApplication : Application() , KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}