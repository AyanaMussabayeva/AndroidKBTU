package supermegadeveloper.ayana.mid2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_details.*
import kotlin.concurrent.thread

class DetailsActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    override fun onShowPress(e: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDown(e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLongPress(e: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        val myDB = LetterDatabase.getInstance(this)
        thread {
            val letter = intent.getParcelableExtra<Letter>("letter")
            val list = myDB?.letterDao()?.getById(letter.id + 1)
            letter_title.text = letter.title
            letter_date.text = letter.date
            letter_message.text = letter.message
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        val letter = intent.getParcelableExtra<Letter>("letter")

        letter_title.text = letter.title
        letter_date.text = letter.date
        letter_message.text = letter.message


    }
}
