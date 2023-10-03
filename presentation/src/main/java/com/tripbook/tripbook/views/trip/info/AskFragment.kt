package com.tripbook.tripbook.views.trip.info

import android.util.Log
import androidx.fragment.app.activityViewModels
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentAskBinding
import com.tripbook.tripbook.viewmodel.InfoViewModel

class AskFragment : BaseFragment<FragmentAskBinding, InfoViewModel>(R.layout.fragment_ask) {

    override val viewModel : InfoViewModel by activityViewModels()

    override fun init() {
        Log.d("넘어옴:::","넘어옴")
    }


}