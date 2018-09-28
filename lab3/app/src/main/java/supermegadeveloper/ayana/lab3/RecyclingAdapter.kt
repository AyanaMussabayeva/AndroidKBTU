package supermegadeveloper.ayana.lab3

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclingAdapter(var context: Context, var dataset: ArrayList<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.item.setOnClickListener {

                context.startActivity(Intent(context, SecondActivity::class.java).putExtra("item", dataset[adapterPosition]))
            }
        }
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val item = dataset[p1]

        p0.itemView.title.text = item.title
        p0.itemView.date.text = item.date
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}