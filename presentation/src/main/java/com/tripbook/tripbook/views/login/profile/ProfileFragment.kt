package com.tripbook.tripbook.views.login.profile

import android.widget.ImageView
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentProfileBinding

class ProfileFragment: BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    override fun initOnViewCreated() {
        binding.profile.setOnClickListener{
            // Q. binding을 인수로 주는거 괜찮은지?
            ProfileDialogFragment(binding).show(requireActivity().supportFragmentManager, "Profile Fragment")
        }
    }
}