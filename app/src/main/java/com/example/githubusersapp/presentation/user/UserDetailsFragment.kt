package com.example.githubusersapp.presentation.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.githubusersapp.R
import com.example.githubusersapp.databinding.UserDetailsFragmentBinding
import com.example.githubusersapp.domain.UserFullInfo
import com.example.githubusersapp.presentation.base.BaseFragment
import com.example.githubusersapp.presentation.base.BaseNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

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
        viewModel.getUserData(args.userName)
    }

    override fun observeData() {
        super.observeData()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userData
                .filterNotNull()
                .collect(::updateScreenData)
        }
    }

    //TODO нужно обновить разметку на более адектватную
    private fun updateScreenData(userFullInfo: UserFullInfo) {
        binding.apply {

            Glide.with(binding.root)
                .load(userFullInfo.userBaseInfo.avatar)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.userAvatar)

            userLogin.text = userFullInfo.userBaseInfo.login
            userOrganization.text = userFullInfo.organization
            userFollowersCount.text = userFullInfo.followersCount.toString()
            userFollowingCount.text = userFullInfo.followingCount.toString()
            userCreatedAt.text = userFullInfo.createdAt
        }
    }
}