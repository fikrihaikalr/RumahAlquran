package com.fikrihaikal.qurancall.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fikrihaikal.qurancall.di.Injection
import com.fikrihaikal.qurancall.ui.home.HomeViewModel
import com.fikrihaikal.qurancall.ui.login.LoginViewModel
import com.fikrihaikal.qurancall.ui.register.RegisterViewModel


class ViewModelFactory(private val context: Context)  : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create (modelClass: Class<T>) : T{
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java)  ->{
                RegisterViewModel(Injection.provideRepository(context)) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(Injection.provideRepository(context)) as T
            }

            else ->throw java.lang.IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)

        }

    }

}