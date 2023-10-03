package com.tripbook.tripbook.views.trip.info


import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentMypageBinding
import com.tripbook.tripbook.viewmodel.InfoViewModel

class MypageFragment : BaseFragment<FragmentMypageBinding, InfoViewModel>(R.layout.fragment_mypage) {

    override val viewModel : InfoViewModel by activityViewModels()

    override fun init() {

        //설정 버튼 클릭 -> 프로필 수정 화면으로 넘어감
        binding.btnSetting.setOnClickListener {
            findNavController().navigate(R.id.action_mypageFragment_to_profileModifyFragment)
        }

        binding.askDetail.setOnClickListener {

        }

        binding.btnLogout.setOnClickListener {

        }

    }

/*    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        val containerId = fragment.arguments?.getInt("containerId") ?: 0

        if (containerId != 0) {
            transaction.replace(containerId, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }*/

}