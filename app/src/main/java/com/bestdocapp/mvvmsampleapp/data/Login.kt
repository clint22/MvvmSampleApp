package com.bestdocapp.mvvmsampleapp.data


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("message")
    val message: String?,
    @SerializedName("token")
    val token: String?,
    @SerializedName("user")
    val user: User?,
    val status: Boolean
) {
    data class User(
        @SerializedName("bio")
        val bio: String,
        @SerializedName("birth_date")
        val birthDate: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("is_seeker")
        val isSeeker: Boolean,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("mobile_no")
        val mobileNo: String,
        @SerializedName("profession")
        val profession: String,
        @SerializedName("user_id")
        val userId: String,
        @SerializedName("user_photo")
        val userPhoto: String
    )
}