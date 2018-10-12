package supermegadeveloper.ayana.midterm

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class LoginActivity : AppCompatActivity() {

    lateinit var myDB : UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDB = UserDatabase.getInstance(this)!!

        val pref = getSharedPreferences("data", Context.MODE_PRIVATE)


        loginButton.setOnClickListener{
            val userEmail = emailEdit.toString()
            val userPassword = passwordEdit.toString()


        // adding to database

            thread {
                val list = myDB?.newsDao()?.getAll()
                val user = User(list!!.size + 1, userEmail, userPassword)
                myDB.newsDao().insert(user)

            }


            Toast.makeText(this, "hello  " + userEmail, Toast.LENGTH_LONG).show()

            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }

    }

}
