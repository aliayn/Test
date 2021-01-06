package com.aliayn.test.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.aliayn.test.R
import com.aliayn.test.base.BaseFragment
import com.aliayn.test.data.local.entity.User
import com.aliayn.test.extenstion.*
import com.aliayn.test.helper.Config
import com.aliayn.test.helper.Constance.USER
import com.aliayn.test.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : BaseFragment(R.layout.profile_fragment) {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<User>(USER)?.let { setupView(it) } ?: activity?.onBackPressed()
    }

    private fun setupView(user: User) {
        val isAdmin = Config.isAdmin
        edt_user_name.beDisableIf(isAdmin)
        edt_password.beDisableIf(isAdmin)
        edit_view_group.beGoneIf(isAdmin)

        edt_user_name.setText(user.userName)
        edt_password.setText(user.passWord)
        txt_full_name.text = user.fullName
        user.imageUrl?.let { img_avatar.loadImage(it) }

        btn_update.setOnClickListener { update(user) }
        btn_delete.setOnClickListener { delete(user) }
    }

    private fun delete(user: User) {
        userViewModel.delete(user)
        activity?.onBackPressed()
        context?.toast(resources.getString(R.string.delete_success))
    }

    private fun update(user: User) {
        if (edt_user_name.text.isNotEmpty() && edt_password.text.isNotEmpty()) {
            if (edt_password.text.toString().isPasswordValid()) {
                user.userName = edt_user_name.text.toString()
                user.passWord = edt_password.text.toString()
                userViewModel.update(user)
                context?.toast(resources.getString(R.string.update_success))
            } else {
                context?.toast(resources.getString(R.string.error_in_validate_password))
            }
        } else {
            context?.toast(resources.getString(R.string.error_in_update))
        }
    }
}