package supermegadeveloper.ayana.mid2
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.letter_item.view.*

class LetterAdapter(var context: Context, var dataset: ArrayList<Letter>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.letter_item, parent, false))

    }


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.letter_item.setOnClickListener {

                val act = context as Activity

                act.startActivityForResult(Intent(context, DetailsActivity::class.java).putExtra("letter", dataset[adapterPosition]), 1)


            }
        }
    }


    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val letter = dataset[position]

        holder.itemView.title.text = letter.title
        holder.itemView.message.text = letter.message
        holder.itemView.date.text = letter.date

    }
}