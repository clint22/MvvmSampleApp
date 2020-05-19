package com.bestdocapp.mvvmsampleapp.data.source

import androidx.lifecycle.LiveData
import com.bestdocapp.mvvmsampleapp.Result
import com.bestdocapp.mvvmsampleapp.data.Login

interface AppDataSource {

    suspend fun login(username: String, password: String)

    suspend fun observeLogin(): LiveData<Result<Login>>

    suspend fun getLogin(username: String, password: String): Result<Login>

}