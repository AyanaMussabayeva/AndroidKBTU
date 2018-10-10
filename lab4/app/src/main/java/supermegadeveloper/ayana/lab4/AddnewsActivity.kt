package supermegadeveloper.ayana.lab4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_addnews.*
import kotlin.concurrent.thread
import android.app.Activity
import android.content.Intent
import java.text.SimpleDateFormat
import java.util.*


class AddnewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnews)

        val myDB = NewsDatabase.getInstance(this)



        post_button.setOnClickListener{
            val myNewsTitle  = edit_newstitle.text.toString()
            val myNews = edit_news.text.toString()

            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())


            thread {
                val list = myDB?.newsDao()?.getAll()
                val news = News(list!!.size + 1, myNewsTitle, currentDate, myNews)
                myDB.newsDao().insert(news)


                val returnIntent = Intent()
                setResult(Activity.RESULT_OK, returnIntent)
                finish()

            }
        }
    }
}
