package com.tripbook.tripbook.views.login.profile

import android.content.Context.INPUT_METHOD_SERVICE
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentNicknameBinding
import com.tripbook.tripbook.viewmodel.ProfileViewModel

class NicknameFragment: BaseFragment<FragmentNicknameBinding>(R.layout.fragment_nickname) {

    private val viewModel: ProfileViewModel by activityViewModels()

    override fun init() {
        nicknameTextWatcher()
        binding.viewModel = viewModel
        binding.nicknameButton.setOnClickListener{
            if(duplicateCheck()){
                viewModel.setNickname(binding.nickname.text.toString())
                findNavController().navigate(R.id.action_nicknameFragment_to_profileFragment)
            }
        }
        binding.nickname.setOnEditorActionListener { _, action, _ ->
            if(action == EditorInfo.IME_ACTION_DONE){
                val imm = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.nickname.windowToken, 0)
                true
            }else
                false
        }
    }

    private fun nicknameTextWatcher(){
        binding.nickname.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.setNicknameValid(binding.nickname.isNicknameValid(text!!))
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    // 서버 확인 따로 -> 버튼 누르면
    private fun duplicateCheck(): Boolean{
        // 닉네임 중복확인 API 호출
        return true
    }
}