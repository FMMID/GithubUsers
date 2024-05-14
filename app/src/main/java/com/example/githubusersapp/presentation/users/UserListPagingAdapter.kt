package com.example.githubusersapp.presentation.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubusersapp.R
import com.example.githubusersapp.databinding.UserBaseInfoItemBinding
import com.example.githubusersapp.domain.UserBaseInfo

class UserListPagingAdapter(
    private val onItemClickCallback: (String) -> Unit
) : PagingDataAdapter<UserBaseInfo, UserListPagingAdapter.UserListViewHolder>(UserBaseInfoComparator) {

    inner class UserListViewHolder(
        private val binding: UserBaseInfoItemBinding,
        private val onItemClickCallback: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserBaseInfo) {
            //TODO реализовать нормальную загрузку (Отдельный компонент)
            Glide.with(binding.root)
                .load(user.avatar)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.userAvatar)

            binding.userId.text = user.id.toString()
            binding.userLogin.text = user.login
            binding.root.setOnClickListener {
                onItemClickCallback(user.login)
            }
        }
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding = UserBaseInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListViewHolder(binding, onItemClickCallback)
    }
}

object UserBaseInfoComparator : DiffUtil.ItemCallback<UserBaseInfo>() {

    override fun areItemsTheSame(oldItem: UserBaseInfo, newItem: UserBaseInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserBaseInfo, newItem: UserBaseInfo): Boolean {
        return oldItem == newItem
    }
}