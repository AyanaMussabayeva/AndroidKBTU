package kbtu.test.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d( "MainActivity", "--------------- onCreate()")

//        loginButton.setOnClickListener(View.OnClickListener {
//            val intent = Intent(this, secondActivity::class.java)
//            intent.putExtra("key", "value")
//            startActivity(intent)
//        })

    }

    fun onClick(view: View){
        when(view.id){
            R.id.loginButton ->{
                val intent = Intent(this, secondActivity::class.java)
                intent.putExtra("key", "value")
                startActivity(intent)

            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d( "MainActivity", "--------------- onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d( "MainActivity", "--------------- onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( "MainActivity", "--------------- onRestart()") //TODO
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "--------------- onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "--------------- onStop()")
    }
}
