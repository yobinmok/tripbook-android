package com.tripbook.tripbook.views.trip.info

import androidx.fragment.app.activityViewModels
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentProfileModifyBinding
import com.tripbook.tripbook.viewmodel.InfoViewModel

class ProfileModifyFragment : BaseFragment<FragmentProfileModifyBinding, InfoViewModel>(R.layout.fragment_profile_modify) {

    override val viewModel : InfoViewModel by activityViewModels()

    override fun init() {
        binding.viewModel = viewModel
    }


}