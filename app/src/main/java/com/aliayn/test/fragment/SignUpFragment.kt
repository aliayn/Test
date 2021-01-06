package com.aliayn.test.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.aliayn.test.R
import com.aliayn.test.base.BaseFragment
import com.aliayn.test.data.local.entity.User
import com.aliayn.test.extenstion.*
import com.aliayn.test.helper.Config
import com.aliayn.test.helper.Constance.GALLERY_PICTURE
import com.aliayn.test.helper.Constance.USER
import com.aliayn.test.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.sign_up_fragment.*


class SignUpFragment : BaseFragment(R.layout.sign_up_fragment) {

    private val userViewModel: UserViewModel by activityViewModels()
    private val user by lazy { User() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == GALLERY_PICTURE) {
            data?.data?.let {
                user.imageUrl = it.toString()
                btn_camera.loadImage(it)
            } ?: run {
                context?.toast(resources.getString(R.string.error_in_getting_photo))
            }
        }
    }

    private fun setupView() {
        btn_camera.setOnClickListener { getImage() }
        btn_signUp.setOnClickListener { checkForSignUp() }
    }

    private fun checkForSignUp() {
        when {
            edt_full_name.text.isEmpty() -> {
                return
            }
            edt_username_or_email.text.isEmpty() -> {
                return
            }
            checkPasswordForSignUp() -> {
                signUp()
            }
        }
    }

    private fun checkPasswordForSignUp(): Boolean {
        if (edt_pass_word.text.isNotEmpty()) {
            return if (edt_pass_word.text.toString().isPasswordValid()) {
                if (edt_pass_word.text.toString() == edt_confirm_pass_word.text.toString()) {
                    true
                } else {
                    context?.toast(resources.getString(R.string.error_in_confirm_password))
                    false
                }
            } else {
                context?.toast(resources.getString(R.string.error_in_validate_password))
                false
            }
        } else {
            context?.toast(resources.getString(R.string.error_in_empty_password))
            return false
        }
    }

    private fun signUp() {
        user.apply {
            fullName = edt_full_name.text.toString()
            userName = edt_username_or_email.text.toString()
            passWord = edt_pass_word.text.toString()
        }
        userViewModel.insert(user)
        Config.isAdmin = false
        navigate(R.id.action_signUpFragment_to_profileFragment, bundleOf(USER to user))
    }

    private fun getImage() = showGalleryIntent()

}