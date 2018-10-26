package supermegadeveloper.ayana.lab5

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_addnews.*
import java.text.SimpleDateFormat
import java.util.*
import javax.security.auth.callback.Callback

class AddnewsActivity : AppCompatActivity() {

    val client by lazy {
        ApiClient.create()
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnews)


        post_button.setOnClickListener{
            val myNewsTitle  = edit_newstitle.text.toString()
            val myNews = edit_news.text.toString()

            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())

            val post = News(1, 1, "title", "body", currentDate)

            postNews(post)

            val returnIntent = Intent()
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

    }
    private fun postNews(news: News) {

        disposable = client.addNews(news)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.v("POSTED News", "" + news ) },
                        { error -> Log.e("ERROR", error.message ) }
                )
    }
}

