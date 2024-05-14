package com.example.githubusersapp.presentation.user

import androidx.lifecycle.viewModelScope
import com.example.githubusersapp.domain.IUserRepository
import com.example.githubusersapp.domain.UserFullInfo
import com.example.githubusersapp.presentation.base.BaseNavigation
import com.example.githubusersapp.presentation.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsVM @Inject constructor(
    private val userRepository: IUserRepository
) : BaseVM<BaseNavigation>() {

    private val _userData: MutableStateFlow<UserFullInfo?> = MutableStateFlow(null)
    val userData = _userData.asStateFlow()

    fun getUserData(userName: String) {
        viewModelScope.launch {
            _userData.emit(userRepository.getUserInfo(userName))
        }
    }
}