package com.tripbook.tripbook.viewmodel

import androidx.lifecycle.viewModelScope
import com.tripbook.base.BaseViewModel
import com.tripbook.tripbook.domain.model.MemberInfo
import com.tripbook.tripbook.domain.usecase.LoginUseCase
import com.tripbook.tripbook.domain.usecase.MemberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val memberUseCase: MemberUseCase,
) : BaseViewModel() {

    private val _memberInfo : MutableStateFlow<MemberInfo?> = MutableStateFlow(null)
    val memberInfo : StateFlow<MemberInfo?> = _memberInfo

    fun getMemberInfo() = memberUseCase().onEach {
        _memberInfo.emit(it)
    }.launchIn(viewModelScope)

}