package com.bestdocapp.mvvmsampleapp.login

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bestdocapp.mvvmsampleapp.getOrAwaitValue
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This class will maintain the unit test cases of the LoginViewModel
 * */
@RunWith(AndroidJUnit4::class)
class LoginViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    /**
     * A sample unit test function that will return a 'Unit' if it is success
     * */
    @Test
    fun test_shouldReturnUnit() {

        // Given a fresh TasksViewModel
        val loginViewModel = LoginViewModel()

        // When adding a new task
        loginViewModel.testEvent()

        // Then the new task event is triggered
        val value = loginViewModel.testEventResult.getOrAwaitValue()
        Log.v("value is", "Called : $value")
        assertThat(value, not(nullValue()))
    }

}