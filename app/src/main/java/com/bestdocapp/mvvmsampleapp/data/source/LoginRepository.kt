package com.bestdocapp.mvvmsampleapp.data.source

import com.bestdocapp.mvvmsampleapp.Result
import com.bestdocapp.mvvmsampleapp.data.Login

interface LoginRepository {

    suspend fun login(username: String, password: String): Result<Login>


}