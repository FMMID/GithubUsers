package com.example.githubusersapp.presentation.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.githubusersapp.databinding.UserDetailsFragmentBinding
import com.example.githubusersapp.presentation.base.BaseFragment
import com.example.githubusersapp.presentation.base.BaseNavigation
import dagger.hilt.android.AndroidEntryPoint

//Todo impl get user details
@AndroidEntryPoint
class UserDetailsFragment : BaseFragment<BaseNavigation, UserDetailsFragmentArgs, UserDetailsFragmentBinding, UserDetailsVM>() {

    override val args by navArgs<UserDetailsFragmentArgs>()
    override val viewModel: UserDetailsVM by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): UserDetailsFragmentBinding {
        return UserDetailsFragmentBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.helloText.text = args.userId
    }
}