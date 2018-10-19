package supermegadeveloper.ayana.mid2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.letter_item.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var myDB: LetterDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val text = pref.getString("saved_email","0")
        Toast.makeText(this,"hello " + text + "!", Toast.LENGTH_LONG).show()

//        myDB = LetterDatabase.getInstance(this)!!
//        val title = "email from Mirzhana"
//        val message = "hi! how are you?"
//        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
//        val currentDate = sdf.format(Date())
//
//        addToDB(title, currentDate, message)
//
//        addToDB("letter from Amonya", currentDate, "hello!")
//
//
//        val letterPref = getSharedPreferences("letterData", Context.MODE_PRIVATE)

        buttonAdd.setOnClickListener {
            myDB = LetterDatabase.getInstance(this)!!
            val title = "email from Mirzhana"
            val message = "hi! how are you?"
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())

            addToDB(title, currentDate, message)

        }

    }

    fun addToDB(title:String, date:String, message:String){

        thread {
            val list = myDB.letterDao().getAll()
            val letter = Letter(list.size + 1, title, date, message)
            myDB.letterDao().insert(letter)
            loadData(myDB)

        }

    }

        fun onDataLoaded(dataset: ArrayList<Letter>) {
            runOnUiThread {
                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter = LetterAdapter(this, dataset)
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    recycler.layoutManager = GridLayoutManager(this, 2)
                } else {
                    recycler.layoutManager = LinearLayoutManager(this)
                }
            }
        }

        fun loadData(myDB: LetterDatabase) {
            val dataset: ArrayList<Letter> = ArrayList()
            thread {
                val list = myDB.letterDao().getAll()
                for (i in 0..(list.size - 1)) {
                    dataset.add(list[i])
                }
                onDataLoaded(dataset)
            }
        }


}
