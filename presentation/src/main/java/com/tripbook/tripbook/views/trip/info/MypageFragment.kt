package com.tripbook.tripbook.views.trip.info


import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentMypageBinding
import com.tripbook.tripbook.viewmodel.InfoViewModel

class MypageFragment : BaseFragment<FragmentMypageBinding, InfoViewModel>(R.layout.fragment_mypage) {

    override val viewModel : InfoViewModel by activityViewModels()

    override fun init() {

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getMemberInfo()
            viewModel.memberInfo.collect {
                if(it != null) {
                    binding.nickname.text = it.name

                    Log.d("테스트닉네임:::", "닉네임" + it.name)

                }
            }
        }

        //설정 -> 프로필 수정
        binding.btnSetting.setOnClickListener {
            findNavController().navigate(R.id.action_mypageFragment_to_profileModifyFragment)
        }

        //1:1 문의
        binding.askDetail.setOnClickListener {
            findNavController().navigate(R.id.action_mypageFragment_to_askFragment)
        }

        //로그아웃
        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_mypageFragment_to_logoutFragment)
        }

    }


}