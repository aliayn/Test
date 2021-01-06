package com.aliayn.test.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aliayn.test.data.local.dao.UserDao
import com.aliayn.test.data.local.entity.User
import com.aliayn.test.helper.Constance.DATABASE_NAME
import com.aliayn.test.helper.SingletonHolder

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object : SingletonHolder<Context, UserDataBase>({
        Room.databaseBuilder(it.applicationContext, UserDataBase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    })
}