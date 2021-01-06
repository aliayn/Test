package com.aliayn.test.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliayn.test.data.local.entity.User
import com.aliayn.test.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(
        private val userRepository: UserRepository
) : ViewModel() {

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) { userRepository.insert(user) }

    fun update(user: User) = viewModelScope.launch(Dispatchers.IO) { userRepository.update(user) }

    fun delete(user: User) = viewModelScope.launch(Dispatchers.IO) { userRepository.delete(user) }

    fun getAllUsers(): LiveData<List<User>> = userRepository.getAllUsers()

    fun isExists(userName: String, passWord: String) = userRepository.isExists(userName, passWord)

    fun getCertainUser(userName: String, passWord: String) = userRepository.getCertainUser(userName, passWord)
}