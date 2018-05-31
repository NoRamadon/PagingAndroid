package com.example.pagingandroid

import android.app.Application
import com.example.pagingandroid.di.AppComponent
import com.example.pagingandroid.di.DaggerAppComponent
import com.example.pagingandroid.di.DataBaseModule

open class PagingApplication: Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .dataBaseModule(DataBaseModule(this))
                .build()
    }
}