package com.tripbook.tripbook.views.trip.info

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.activityViewModels
import com.tripbook.base.BaseDialogFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentMemberdelDialogBinding
import com.tripbook.tripbook.viewmodel.MemberDeleteViewModel

class MemberDelDialogFragment :
    BaseDialogFragment<FragmentMemberdelDialogBinding, MemberDeleteViewModel>(R.layout.fragment_memberdel_dialog) {

    override val viewModel: MemberDeleteViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogTheme)
        isCancelable = true
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }


    /*
    1. 마이페이지에서 회원탈퇴 버튼 클릭 시 해당 팝업 띄우기
    2. 닉네임이 현 회원 정보와 맞는지 로직 추가
    3. 맞을 시 탈퇴 버튼 클릭 가능 (아니면 아니라고 표시)
    4. 탈퇴 버튼 클릭 시 delete api 실행하면서 success 팝업으로 이동
     */
    override fun init() {


        binding.icnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnMemberDelCancel.setOnClickListener {
            dismiss()
        }

    }
}