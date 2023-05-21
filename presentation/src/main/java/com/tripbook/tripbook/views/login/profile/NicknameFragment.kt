package com.tripbook.tripbook.views.login.profile

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentNicknameBinding
import com.tripbook.tripbook.viewmodel.ProfileViewModel

class NicknameFragment: BaseFragment<FragmentNicknameBinding>(R.layout.fragment_nickname) {

    private val viewModel: ProfileViewModel by viewModels()

    override fun initOnViewCreated() {
        binding.viewModel = viewModel
        binding.nicknameButton.setOnClickListener{
            findNavController().navigate(R.id.action_nicknameFragment_to_profileFragment)
        }
        binding.nickname.setOnEditorActionListener { _, action, _ ->
            if(action == EditorInfo.IME_ACTION_DONE){
                val imm = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.nickname.windowToken, 0)
                validUI()
                true
            }else
                false
        }
    }

    private fun validUI(){
        if(isValid(binding.nickname.text.toString()))
            viewModel.setNicknameValid(true)
        else
            viewModel.setNicknameValid(false)
    }

    private fun isValid(nickname: String): Boolean{
        val regex = Regex("^[0-9a-zA-Z가-힣]+\$") // 닉네임 조건: 영문, 한글, 숫자를 포함하는 10글자 이내 문자열(자음, 모음, 공백 X)
        return if(nickname.length > 10){
            binding.nicknameAlert.text = getString(R.string.nickname_length_alert)
            false
        } else if (!nickname.matches(regex)) {
            binding.nicknameAlert.text = getString(R.string.nickname_sign_alert)
            false
//        } else if(true){
//            // 아이디 중복 여부 확인 -> 서버 통신
//            false
        }else
            true
    }
}