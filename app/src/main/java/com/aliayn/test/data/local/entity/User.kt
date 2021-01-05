package com.aliayn.test.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "user_table", indices = [(Index(value = ["id"], unique = true))])
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "fullName") var fullName: String,
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "passWord") var passWord: String,
    @ColumnInfo(name = "imageUrl") var imageUrl: String
)
