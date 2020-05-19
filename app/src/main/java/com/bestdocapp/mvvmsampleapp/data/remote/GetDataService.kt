package com.bestdocapp.mvvmsampleapp.data.remote

import com.bestdocapp.mvvmsampleapp.KEY_PASSWORD
import com.bestdocapp.mvvmsampleapp.KEY_USERNAME
import com.bestdocapp.mvvmsampleapp.data.Login
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GetDataService {

    @FormUrlEncoded
    @POST("api/login/")
    suspend fun login(
        @Field(KEY_USERNAME) username: String?,
        @Field(KEY_PASSWORD) password: String?
    ): Response<Login?>?
}