package com.example.githubusersapp.presentation.users

import com.example.githubusersapp.presentation.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//TODO impliment get paging data, navigate to user details
@HiltViewModel
class UserListVM @Inject constructor() : BaseVM<UserListNavigation>()