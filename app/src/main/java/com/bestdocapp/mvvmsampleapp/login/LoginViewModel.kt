package com.bestdocapp.mvvmsampleapp.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bestdocapp.mvvmsampleapp.data.Login
import com.bestdocapp.mvvmsampleapp.data.DefaultLoginRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Login>()
    val loginResult: LiveData<Login> = _loginResult

    private val _testEventResult = MutableLiveData<Unit>()
    val testEventResult: LiveData<Unit> = _testEventResult


    private val loginRepository = DefaultLoginRepository()

    fun login(
        username: String,
        password: String
    ) {
        viewModelScope.launch {

            _loginResult.value = loginRepository.login(
                username = username,
                password = password
            )
        }
    }

    /**
     * Just a test method which will return a 'Unit' when triggered
    * */
    fun testEvent() {

        _testEventResult.value = Unit
    }

}
