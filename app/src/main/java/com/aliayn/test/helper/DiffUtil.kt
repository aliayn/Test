package com.aliayn.test.helper

import androidx.recyclerview.widget.DiffUtil
import com.aliayn.test.data.local.entity.User

val userDiffUtil by lazy {
    object : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem == newItem
    }
}
