package com.example.noteapp

import android.app.Application
import com.example.noteapp.data.MainDataBase

class App : Application() {
    val database by lazy { MainDataBase.createDataBase(this) }
}