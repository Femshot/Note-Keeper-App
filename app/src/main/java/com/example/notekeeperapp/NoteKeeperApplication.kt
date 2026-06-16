package com.example.notekeeperapp

import android.app.Application
import com.example.notekeeperapp.data.respository.AppContainer

class NoteKeeperApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}