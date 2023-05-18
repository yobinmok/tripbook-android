package com.tripbook.tripbook.views.login.profile

import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentNicknameBinding

class NicknameFragment: BaseFragment<FragmentNicknameBinding>(R.layout.fragment_nickname) {
    override fun initOnViewCreated() {
        binding.nicknameButton.setOnClickListener{
        }
    }
}