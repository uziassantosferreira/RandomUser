package com.uziasferreira.randomuser.users.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uziasferreira.randomuser.R
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser
import kotlinx.android.synthetic.main.list_item_user.view.*

interface UsersAdapter {
    fun setUsers(list: List<PresentationUser>)
}
class UserAdapterImpl: RecyclerView.Adapter<UserViewHolder>() {
    private val users = mutableListOf<PresentationUser>()

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.textviewName.text = users.get(position).name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder
            = UserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_user, parent, false))

    fun setUsers(list: List<PresentationUser>){
        users.removeAll(users)
        users.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

}

class UserViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)


