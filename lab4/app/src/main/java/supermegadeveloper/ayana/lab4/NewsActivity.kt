package supermegadeveloper.ayana.lab4

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_news.*
import kotlin.concurrent.thread
import android.app.Activity
import android.content.res.Configuration
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.news_item.*


class NewsActivity : AppCompatActivity() {

    lateinit var myDB: NewsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val text = pref.getString("saved_email","0")
        Toast.makeText(this,"hello " + text + "!", Toast.LENGTH_LONG).show()

        myDB = NewsDatabase.getInstance(this)!!
        loadData(myDB!!)

        buttonAdd.setOnClickListener {

            val i = Intent(this, AddnewsActivity::class.java)
            startActivityForResult(i, 1)

        }
//
//        news_item.setOnClickListener{
//            val intent = Intent(this, NewsdetailsActivity::class.java)
//            startActivity(intent)
//        }

    }

    fun loadData(myDB: NewsDatabase) {
        val dataset: ArrayList<News> = ArrayList()
        thread {
            val list = myDB.newsDao().getAll()
            for (i in 0..(list.size - 1)) {
                dataset.add(list[i])
            }

            onDataLoaded(dataset)
        }
    }

    fun onDataLoaded(dataset: ArrayList<News>) {
        runOnUiThread {
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.adapter = NewsAdapter(this, dataset)

            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                recycler.layoutManager = GridLayoutManager(this, 2)
            } else {
                recycler.layoutManager = LinearLayoutManager(this)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
               loadData(myDB!!)
            }

        }
    }
}
