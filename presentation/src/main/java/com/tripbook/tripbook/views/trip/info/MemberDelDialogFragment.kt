package com.tripbook.tripbook.views.trip.info

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.tripbook.base.BaseDialogFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentMemberdelDialogBinding

import com.tripbook.tripbook.viewmodel.InfoViewModel
import com.tripbook.tripbook.viewmodel.MemberDeleteViewModel

import kotlinx.coroutines.launch
import timber.log.Timber

class MemberDelDialogFragment :
    BaseDialogFragment<FragmentMemberdelDialogBinding, MemberDeleteViewModel>(R.layout.fragment_memberdel_dialog) {

    override val viewModel: MemberDeleteViewModel by activityViewModels()
    private val infoViewModel: InfoViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogTheme)
        isCancelable = true
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setGravity(Gravity.CENTER)
    }

    override fun init() {

        binding.viewModel = viewModel
        binding.infoViewModel = infoViewModel

        val nickName : String? = infoViewModel.nickname.value //현재 내 닉네임

        val errorMsg = requireContext().getString(R.string.memberDel_error_msg)

        binding.nickname.addTextChangedListener(onTextChange())

        binding.btnMemberDelConfirm.setOnClickListener {

            viewModel.setDelNickName(binding.nickname.text.toString())

            if(viewModel.isNickCheck(nickName.toString())) {
                viewModel.setError("")
                deleteMember()

            } else {
                viewModel.setError(errorMsg)
            }

        }

        binding.icnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnMemberDelCancel.setOnClickListener {
            dismiss()
        }

    }

    private fun onTextChange(): TextWatcher {
        return object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                viewModel.setError("")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setError("")
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.setError("")
            }
        }
    }

    private fun deleteMember() {

        val email : String? = infoViewModel.email.value

        viewLifecycleOwner.lifecycleScope.launch {

            if (email != null) {
                viewModel.deleteMember(email).collect {
                    if (it) {
                        Timber.tag("memberDel").d("회원탈퇴 성공")
                        MemberDelSuccessDialogFragment().show(childFragmentManager, "MemberDelSuccessDialogFragment Fragment")
                    } else {
                        Timber.tag("error memberDel").d("회원탈퇴 실패")
                    }
                }
            }
        }
    }

}