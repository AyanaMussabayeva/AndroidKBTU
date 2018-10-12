package supermegadeveloper.ayana.midterm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import supermegadeveloper.ayana.midterm.R.id.container

class Main2Activity : AppCompatActivity() {

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> FragmentFirst()
            else -> FragmentSecond()
        }

        override fun getCount(): Int {
            return 2
        }
    }

    private var myAdapter: SectionsPagerAdapter ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setSupportActionBar(toolbar)

        myAdapter = SectionsPagerAdapter(supportFragmentManager)

        container.adapter = myAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

        buttonAdd.setOnClickListener {
            //go to todo_activity to add new
            val intent = Intent(this, todoActivity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)

        }

    }
}
