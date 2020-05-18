package com.bestdocapp.mvvmsampleapp

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

    /**
     * This will return the result if the operation is success
    * */
    data class Success<out T>(val data: T) : Result<T>()
    /**
     * This will return the Exception if the operation is error
     * */
    data class Error(val exception: Exception) : Result<Nothing>()
    /**
     * This will return if the operation is loading or not
     * */
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null