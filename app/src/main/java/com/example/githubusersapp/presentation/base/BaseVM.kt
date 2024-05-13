package com.example.githubusersapp.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

open class BaseVM<Navigation : BaseNavigation> : ViewModel() {

    protected val mutableStateFlowNavigation = MutableSharedFlow<Navigation>()
    val stateFlowNavigation = mutableStateFlowNavigation.asSharedFlow()
}