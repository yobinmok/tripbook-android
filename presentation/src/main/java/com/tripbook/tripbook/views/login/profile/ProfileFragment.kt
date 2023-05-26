package com.tripbook.tripbook.views.login.profile

import androidx.fragment.app.activityViewModels
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentProfileBinding
import com.tripbook.tripbook.viewmodel.ProfileViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by activityViewModels()

    override fun init() {
        binding.viewModel = viewModel
        binding.profile.setOnClickListener {
            ProfileDialogFragment().show(
                requireActivity().supportFragmentManager,
                "Profile Fragment"
            )
        }
        binding.profileButton.setOnClickListener {

        }
        binding.profileLater.setOnClickListener {

        }
    }
}