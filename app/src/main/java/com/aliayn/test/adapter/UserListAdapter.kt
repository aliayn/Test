package com.aliayn.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aliayn.test.R
import com.aliayn.test.data.local.entity.User
import com.aliayn.test.helper.userDiffUtil

class UserListAdapter constructor(
    private val deleteCallback: (User) -> Unit,
    private val selectedCallback: (User) -> Unit
) :
    ListAdapter<User, UserListAdapter.ViewHolder>(userDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_list_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {

        }
    }

}