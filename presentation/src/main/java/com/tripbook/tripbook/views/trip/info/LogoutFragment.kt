package com.tripbook.tripbook.views.trip.info

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.auth0.android.Auth0
import com.tripbook.auth.logout
import com.tripbook.base.BaseFragment
import com.tripbook.tripbook.R
import com.tripbook.tripbook.databinding.FragmentLoginBinding
import com.tripbook.tripbook.viewmodel.InfoViewModel


class LogoutFragment : BaseFragment<FragmentLoginBinding, InfoViewModel>(R.layout.fragment_logout) {

    override val viewModel : InfoViewModel by activityViewModels()
    private lateinit var auth0: Auth0

    override fun init() {

        auth0 = Auth0(
            getString(com.tripbook.tripbook.libs.auth.R.string.com_auth_client_id),
            getString(com.tripbook.tripbook.libs.auth.R.string.com_auth_domain)
        )

        requireContext().logout(auth0)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_logoutFragment_to_loginFragment)
        }, 3000)
    }

}

