package com.aliayn.test.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.aliayn.test.R
import com.aliayn.test.adapter.UserListAdapter
import com.aliayn.test.base.BaseFragment
import com.aliayn.test.data.local.entity.User
import com.aliayn.test.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : BaseFragment(R.layout.list_fragment) {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val adapter = UserListAdapter { deleteUser(it) }
        user_list_recycler.adapter = adapter

        userViewModel.getAllUsers().observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun deleteUser(user: User) {
        userViewModel.delete(user)
    }
}