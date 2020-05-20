package com.bestdocapp.mvvmsampleapp.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bestdocapp.mvvmsampleapp.Result
import com.bestdocapp.mvvmsampleapp.data.Login
import com.bestdocapp.mvvmsampleapp.data.source.AppDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Implementation of the data source using the remote APIs.
 * */
object RemoteDataSource : AppDataSource {

    private val observableLogin = MutableLiveData<Result<Login>>()
    private lateinit var login: Login

    override suspend fun login(username: String, password: String) {
        observableLogin.value = getLogin(username, password)
    }

    override suspend fun observeLogin(): LiveData<Result<Login>> {
        return observableLogin
    }

    override suspend fun getLogin(username: String, password: String): Result<Login> {
        withContext(Dispatchers.IO) {

            try {
                val service = ApiFactory.retrofit().create(GetDataService::class.java)
                val call = service.login(
                    username = username,
                    password = password
                )
                if (call?.isSuccessful!!) {
                    call.body().let { loginResponse ->

                        login = Login(
                            message = loginResponse?.message,
                            token = loginResponse?.token,
                            user = loginResponse?.user,
                            status = true
                        )

                    }
                } else {
                    login = Login(
                        message = "Invalid credentials",
                        token = "",
                        user = null,
                        status = false
                    )

                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
        return Result.Success(login)
    }


}
