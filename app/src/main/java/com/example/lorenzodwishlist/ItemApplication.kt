package com.example.lorenzodwishlist

import android.app.Application

class ItemApplication : Application() {
    val db by lazy { ItemDatabase.getInstance(this) }
}