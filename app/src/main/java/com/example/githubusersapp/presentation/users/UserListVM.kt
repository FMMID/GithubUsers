package com.example.githubusersapp.presentation.users

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.githubusersapp.domain.IUserRepository
import com.example.githubusersapp.presentation.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListVM @Inject constructor(
    private val userRepository: IUserRepository
) : BaseVM<UserListNavigation>() {

    val usersFlow = userRepository.getFlowOfUsers().cachedIn(viewModelScope)

    fun goToUserDetails(login: String) {
        viewModelScope.launch {
            mutableStateFlowNavigation.emit(UserListNavigation.NavigateToUserDetails(login))
        }
    }
}