package com.bestdocapp.mvvmsampleapp.data

import com.bestdocapp.mvvmsampleapp.data.remote.ApiFactory
import com.bestdocapp.mvvmsampleapp.data.remote.GetDataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository {

    private var login: Login? = null
    suspend fun login(
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
    }


}

