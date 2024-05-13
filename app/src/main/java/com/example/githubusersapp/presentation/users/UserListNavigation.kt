package com.example.githubusersapp.presentation.users

import androidx.navigation.NavDirections
import com.example.githubusersapp.presentation.base.BaseNavigation

sealed class UserListNavigation(navDirections: NavDirections) : BaseNavigation(navDirections) {

    data class NavigateToUserDetails(val userId: String) : UserListNavigation(
        UserListFragmentDirections.actionUsersListToUserDetails(userId)
    )
}