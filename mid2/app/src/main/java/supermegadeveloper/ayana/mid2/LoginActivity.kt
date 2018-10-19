package supermegadeveloper.ayana.mid2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val pref = getSharedPreferences("data", Context.MODE_PRIVATE)


        loginButton.setOnClickListener {

            val emailText  = emailEdit.text.toString()
            val passwordText = passwordEdit.text.toString()

            pref.edit().putString("saved_email", emailText).apply()
            pref.edit().putString("saved_password", passwordText).apply()

            val text = pref.getString("saved_email", "0")



            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }
    }
}
