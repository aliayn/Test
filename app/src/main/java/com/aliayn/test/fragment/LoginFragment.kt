package com.aliayn.test.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.aliayn.test.R
import com.aliayn.test.base.BaseFragment
import com.aliayn.test.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener { login(edt_user_name.text.toString(),edt_pass_word.text.toString()) }
        btn_signUp.setOnClickListener { signUp() }
    }

    private fun login(userName: String, passWord: String) {

    }

    private fun signUp() {

    }
}