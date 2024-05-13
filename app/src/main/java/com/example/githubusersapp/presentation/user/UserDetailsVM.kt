package com.example.githubusersapp.presentation.user

import com.example.githubusersapp.presentation.base.BaseNavigation
import com.example.githubusersapp.presentation.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//Todo impl get user details
@HiltViewModel
class UserDetailsVM @Inject constructor() : BaseVM<BaseNavigation>() {}