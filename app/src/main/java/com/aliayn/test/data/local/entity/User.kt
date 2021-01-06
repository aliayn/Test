package com.aliayn.test.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table", indices = [(Index(value = ["id"], unique = true))])
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "fullName") var fullName: String? = null,
    @ColumnInfo(name = "userName") var userName: String? = null,
    @ColumnInfo(name = "passWord") var passWord: String? = null,
    @ColumnInfo(name = "imageUrl") var imageUrl: String? = null
) : Parcelable
