package com.example.github_dummy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = arrayListOf<User>()

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var tvName: TextView = itemView.findViewById(R.id.tv_name)
        private var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        private var imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)

        fun bind(user: User){
            tvName.text = user.name
            tvUsername.text = user.username
            imgAvatar.setImageResource(user.avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is UserViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    fun submitList(userList: ArrayList<User>){
        items = userList
    }

    override fun getItemCount(): Int {
        return items.size
    }
}