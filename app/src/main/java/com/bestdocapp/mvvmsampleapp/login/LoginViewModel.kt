package com.bestdocapp.mvvmsampleapp.login
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bestdocapp.mvvmsampleapp.data.Login
import com.bestdocapp.mvvmsampleapp.data.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Login>()
    val loginResult: LiveData<Login> = _loginResult
    private val loginRepository = LoginRepository()

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

}
