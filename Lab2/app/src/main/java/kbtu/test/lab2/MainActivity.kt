package kbtu.test.lab2

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var users: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            users = savedInstanceState.getParcelableArrayList("users")
        }else{
            users = ArrayList()
        }
in

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            recycler.layoutManager = GridLayoutManager(this, 2)
        }else{
            recycler.layoutManager = LinearLayoutManager(this)
        }

        recycler.adapter = UserAdapter(this, users)

        buttonAdd.setOnClickListener {
            users.add(User("Johny Depp", "Pirates of the Caribbean"))
            recycler.adapter.notifyDataSetChanged()
        }


    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putParcelableArrayList("users", users)
    }

}
