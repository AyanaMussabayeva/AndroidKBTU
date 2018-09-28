package kbtu.test.lab2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_item.view.*


class UserAdapter(var context: Context, var users: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]

        holder.itemView.nameText.text = user.name
        holder.itemView.infoText.text = user.info

    }

}