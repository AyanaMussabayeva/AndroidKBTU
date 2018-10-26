package supermegadeveloper.ayana.lab5

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    val client by lazy {
        ApiClient.create()
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val text = pref.getString("saved_email", "0")
        Toast.makeText(this,"hello " + text + "!", Toast.LENGTH_LONG).show()


        buttonAdd.setOnClickListener {
            val i = Intent(this, AddnewsActivity::class.java)
            startActivityForResult(i, 1)
        }
        showNews()
    }

    fun setupRecycler(newsList: ArrayList<News>) {

        recycler.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
//        recycler.adapter = NewsAdapter(this, newsList){
//               Log.v("Article", it.id.toString())
//        }
        recycler.adapter = NewsAdapter(this, newsList)
    }

    private fun showNews() {

        disposable = client.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecycler(result as ArrayList<News>) },
                        { error -> Log.e("ERROR", error.message) }
                )

    }
    private fun showMyNews(id: Int) {

        disposable = client.getNews(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.v("News ID ${id}: ", "" + result) },
                        { error -> Log.e("ERROR", error.message) }
                )

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
    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}

