package supermegadeveloper.ayana.lab4

import android.app.LauncherActivity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(var context: Context, var dataset: ArrayList<News>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val news = dataset[position]

        holder.itemView.news_title.text = news.title
        holder.itemView.news_date.text = news.date

    }


}