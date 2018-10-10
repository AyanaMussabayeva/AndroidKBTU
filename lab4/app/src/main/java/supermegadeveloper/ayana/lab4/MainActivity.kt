package supermegadeveloper.ayana.lab4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pref = getSharedPreferences("data", Context.MODE_PRIVATE)





        loginButton.setOnClickListener {

            val emailText  = emailEdit.text.toString()
            val passwordText = passwordEdit.text.toString()

            pref.edit().putString("saved_email", emailText).apply()
            pref.edit().putString("saved_password", passwordText).apply()

            val text = pref.getString("saved_email", "empty")



            val intent = Intent(this, NewsActivity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }

    }


}
