package supermegadeveloper.ayana.lab4

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref = getSharedPreferences("Settings", Context.MODE_PRIVATE)
    }
    fun onClick(view: View){
        val text  = text_edit.text.toString()

        val editor = pref.edit()
//        editor.putString("saved_text", text)
//        editor.apply()
        pref.edit().putString("saved_text", text).apply()
    }

    fun showData(view: View){
        val text = pref.getString("saved_text", "empty")
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()

    }
}
