package com.tripbook.tripbook.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel: ViewModel() {

    private val _isNicknameValid = MutableStateFlow(false)
    val isNicknameValid: StateFlow<Boolean> = _isNicknameValid

    private val _nicknameError = MutableStateFlow(true)
    val nicknameError: StateFlow<Boolean> = _nicknameError

    private val _isProfileValid = MutableStateFlow(false)
    val isProfileValid: StateFlow<Boolean> = _isProfileValid

    fun setNicknameValid(isValid: Boolean){
        _isNicknameValid.value = isValid
        _nicknameError.value = isValid
    }

    fun setProfileValid(isValid: Boolean){
        _isProfileValid.value = isValid
    }

}