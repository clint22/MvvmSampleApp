package com.bestdocapp.mvvmsampleapp.data.source

import androidx.lifecycle.LiveData
import com.bestdocapp.mvvmsampleapp.Result
import com.bestdocapp.mvvmsampleapp.data.Login

/**
 * This class will contain all the event's required by the class. Must add all the new events in this class
 * */
interface AppDataSource {

    /**
     * This function will call the login API
     * */
    suspend fun login(username: String, password: String)

    /**
     * This function will observe the login function's result
     * */
    suspend fun observeLogin(): LiveData<Result<Login>>

    /**
     * This function will get the result of the login API
     * */
    suspend fun getLogin(username: String, password: String): Result<Login>

}