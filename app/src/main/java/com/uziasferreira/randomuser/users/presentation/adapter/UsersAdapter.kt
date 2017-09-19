package com.uziasferreira.randomuser.users.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.uziasferreira.randomuser.R
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserAdapterImpl: RecyclerView.Adapter<UserViewHolder>() {
    private val users = mutableListOf<PresentationUser>()

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.itemView.textviewName.text = user.fullName.toUpperCase()
        holder.itemView.textviewEmail.text = user.email.toLowerCase()
        Glide.with(holder.itemView).load(user.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.itemView.imageViewAvatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder
            = UserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_user, parent, false))

    fun setUsers(list: List<PresentationUser>){
        users.removeAll(users)
        users.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        users.removeAll(users)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

}

class UserViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)


