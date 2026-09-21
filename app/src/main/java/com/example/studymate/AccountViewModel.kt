package com.example.studymate


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import kotlinx.coroutines.launch

class AccountViewModel: ViewModel() {



    fun login(email: String,password: String){
       viewModelScope.launch {

       }
    }
}