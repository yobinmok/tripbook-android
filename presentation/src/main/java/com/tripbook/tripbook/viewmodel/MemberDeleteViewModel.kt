package com.tripbook.tripbook.viewmodel

import com.tripbook.base.BaseViewModel
import com.tripbook.tripbook.domain.usecase.DeleteMemberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MemberDeleteViewModel @Inject constructor(
    private val deleteMemberUseCase : DeleteMemberUseCase,
) : BaseViewModel() {

    private val _delNickName: MutableStateFlow<String?> = MutableStateFlow(null)
    val delNickName: StateFlow<String?> = _delNickName

    private var _errorMsg = MutableStateFlow("")
    val errorMsg: StateFlow<String> get() = _errorMsg

    fun setDelNickName(nickname: String?) {
        _delNickName.value = nickname
    }

    fun isNickCheck(enteredNickname: String): Boolean {
        return delNickName.value == enteredNickname
    }

    fun setError(error: String) {
            _errorMsg.value = error
    }

    fun deleteMember(email: String): Flow<Boolean> {

        return deleteMemberUseCase(
            email
        )
    }

}