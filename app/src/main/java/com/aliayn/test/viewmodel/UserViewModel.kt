package com.aliayn.test.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aliayn.test.data.repository.UserRepository

class UserViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
}