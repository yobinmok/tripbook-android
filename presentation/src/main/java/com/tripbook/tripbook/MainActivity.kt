package com.tripbook.tripbook

import com.tripbook.tripbook.databinding.ActivityMainBinding
import com.auth0.android.Auth0
import com.tripbook.auth.loginWithBrowser
import com.tripbook.auth.logout
import com.tripbook.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var account: Auth0
    override fun init() {
        account = Auth0(
            getString(com.tripbook.tripbook.libs.auth.R.string.com_auth_client_id),
            getString(com.tripbook.tripbook.libs.auth.R.string.com_auth_domain)
        )

        binding.buttonLogin.setOnClickListener {
            loginWithBrowser(account)
        }

        binding.buttonLogout.setOnClickListener {
            logout(account)
        }
    }

}