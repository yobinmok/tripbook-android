package com.tripbook.tripbook.views.trip.info

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tripbook.base.BaseDialogFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentMemberdelSuccessBinding
import com.tripbook.tripbook.viewmodel.MemberDeleteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MemberDelSuccessDialogFragment :
    BaseDialogFragment<FragmentMemberdelSuccessBinding, MemberDeleteViewModel>(R.layout.fragment_memberdel_success) {

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

    override fun init() {

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            findNavController().navigate(
                MemberDelSuccessDialogFragmentDirections.actionMemberDelSuccessDialogFragmentToLoginFragment()
            )
        }

        binding.icnCancel.setOnClickListener {
            dismiss()
        }

    }
}