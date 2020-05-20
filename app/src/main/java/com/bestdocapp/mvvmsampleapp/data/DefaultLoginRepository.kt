package com.bestdocapp.mvvmsampleapp.data

import com.bestdocapp.mvvmsampleapp.Result
import com.bestdocapp.mvvmsampleapp.data.remote.RemoteDataSource

/**
 * This class will handle the co-ordination b/w the LoginViewModel and the Database Layer ( Remote )
 * */
class DefaultLoginRepository {

    private var login: Login? = null
    private val remoteDataSource: RemoteDataSource = RemoteDataSource

    suspend fun login(
        username: String,
        password: String
    ): Result<Login> {

        return remoteDataSource.getLogin(username = username, password = password)
    }


    /*suspend fun login(
        username: String,
        password: String
    ): Login? {

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

            } catch (e: Exception) {

                println(e)
            }

        }
        return login
    }*/


}

