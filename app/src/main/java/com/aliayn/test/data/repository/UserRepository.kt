package com.aliayn.test.data.repository

import androidx.lifecycle.LiveData
import com.aliayn.test.data.local.dao.UserDao
import com.aliayn.test.data.local.entity.User

class UserRepository constructor(
    private val userDao: UserDao
) {
    
    suspend fun insert(user: User) = userDao.insert(user)

    suspend fun update(user: User) = userDao.update(user)

    suspend fun delete(user: User) = userDao.delete(user)

    fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()
}