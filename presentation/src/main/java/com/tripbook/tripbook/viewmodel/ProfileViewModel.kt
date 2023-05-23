package com.tripbook.tripbook.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.tripbook.tripbook.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel: ViewModel() {

    private val _isNicknameValid = MutableStateFlow(false)
    val isNicknameValid: StateFlow<Boolean> = _isNicknameValid

    private val _nicknameError = MutableStateFlow(true)
    val nicknameError: StateFlow<Boolean> = _nicknameError

    private val _isProfileValid = MutableStateFlow(false)
    val isProfileValid: StateFlow<Boolean> = _isProfileValid

    private var uri: Uri = Uri.parse("drawable://" + R.drawable.ic_image)
    private val _profileUri = MutableStateFlow(uri)
    val profileUri: StateFlow<Uri> = _profileUri

    private var _nickname = MutableStateFlow("")
    val nickname: StateFlow<String> get() = _nickname

    private var _errorMsg = MutableStateFlow("")
    val errorMsg: StateFlow<String> get() = _errorMsg

    fun setNicknameValid(errorMsg: String?){
        if(errorMsg == null){
            _isNicknameValid.value = true
            _nicknameError.value = true
        }else{
            _errorMsg.value = errorMsg
            _isNicknameValid.value = false
            _nicknameError.value = false
        }
    }

    fun setProfileUri(uri: Uri?){
        if(uri == null)
            _isProfileValid.value = false
        else{
            _profileUri.value = uri
            _isProfileValid.value = true
        }
    }

    fun setNickname(nickname: String){
        _nickname.value = nickname
    }

}