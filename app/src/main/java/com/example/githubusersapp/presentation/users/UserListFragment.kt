package com.example.githubusersapp.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusersapp.databinding.UserListFragmentBinding
import com.example.githubusersapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : BaseFragment<UserListNavigation, NavArgs?, UserListFragmentBinding, UserListVM>() {

    override val args: NavArgs? = null
    override val viewModel: UserListVM by viewModels()

    private val userListAdapter by lazy {
        UserListPagingAdapter(viewModel::goToUserDetails)
    }

    private val itemDecorator by lazy {
        DividerItemDecoration(context, RecyclerView.VERTICAL)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(view.context)

            removeItemDecoration(itemDecorator)
            addItemDecoration(itemDecorator)
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): UserListFragmentBinding {
        return UserListFragmentBinding.inflate(inflater, container, false)
    }

    override fun observeData() {
        super.observeData()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usersFlow.collect { pagingData ->
                userListAdapter.submitData(pagingData)
            }
        }
    }
}