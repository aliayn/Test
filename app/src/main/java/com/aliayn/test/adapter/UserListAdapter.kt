package com.aliayn.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aliayn.test.R
import com.aliayn.test.data.local.entity.User
import com.aliayn.test.helper.userDiffUtil
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.user_list_layout.view.*

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

        private val imgAvatar: SimpleDraweeView = itemView.img_avatar
        private val txtFullName: TextView = itemView.txt_full_name
        private val btnDelete: ImageButton = itemView.btn_delete

        fun bind(user: User) {
            imgAvatar.setImageURI(user.imageUrl)
            txtFullName.text = user.fullName
            btnDelete.setOnClickListener { deleteCallback.invoke(user) }
            imgAvatar.setOnClickListener { selectedCallback.invoke(user) }
            txtFullName.setOnClickListener { selectedCallback.invoke(user) }
        }
    }

}