package com.example.assignment_007

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.tokenStore: DataStore<Preferences> by preferencesDataStore(name = "loginInfo")
val tokenKey = stringPreferencesKey("token")
