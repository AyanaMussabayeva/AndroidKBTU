package supermegadeveloper.ayana.lab3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref = getSharedPreferences("Settings", Context.MODE_PRIVATE)

    }

    fun onClick(view: View){

        val emailText  = emailEdit.text.toString()
        val passwordText = passwordEdit.text.toString()

        pref.edit().putString("saved_email", emailText).apply()
        pref.edit().putString("saved_password", passwordText).apply()

        val text = pref.getString("saved_email", "empty")

        Toast.makeText(this, "hello  " + text, Toast.LENGTH_LONG).show()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("key", "value")
        startActivity(intent)

    }


}
