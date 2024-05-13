package com.example.githubusersapp.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import com.example.githubusersapp.databinding.UserListFragmentBinding
import com.example.githubusersapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

//todo impl display users
@AndroidEntryPoint
class UserListFragment : BaseFragment<UserListNavigation, NavArgs?, UserListFragmentBinding, UserListVM>() {

    override val args: NavArgs? = null
    override val viewModel: UserListVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.helloButton.setOnClickListener {
            navigate(UserListNavigation.NavigateToUserDetails(userId = "test"))
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): UserListFragmentBinding {
        return UserListFragmentBinding.inflate(inflater, container, false)
    }
}