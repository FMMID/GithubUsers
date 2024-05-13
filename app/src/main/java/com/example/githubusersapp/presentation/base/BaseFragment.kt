package com.example.githubusersapp.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.launch

abstract class BaseFragment<
        Navigation : BaseNavigation,
        Args : NavArgs?,
        Binding : ViewBinding,
        ViewModel : BaseVM<Navigation>
        > : Fragment() {

    protected abstract val args: Args

    protected abstract val viewModel: ViewModel

    protected lateinit var binding: Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = createBinding(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Binding

    protected open fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.stateFlowNavigation.collect(::navigate)
        }
    }

    protected fun navigate(navigation: Navigation) {
        getSafeNavController().onSuccess {
            it.navigate(navigation.navDirections)
        }
    }

    protected fun getSafeNavController(): Result<NavController> {
        return runCatching { findNavController() }
            .onFailure {
                Log.e(this::class.simpleName, "findNavController not found controller", it)
            }
    }
}