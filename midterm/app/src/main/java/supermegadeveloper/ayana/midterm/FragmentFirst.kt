package supermegadeveloper.ayana.midterm

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentFirst : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_first, container, false)

        val dataset = ArrayList<ListItem>()
        for (i in 1..15) {
            dataset.add(ListItem("Todo " + i.toString(), "28/09/2018"))
        }

        val newsRecycler = root.findViewById(R.id.todoRecycler) as RecyclerView

        newsRecycler.adapter = RecyclingAdapter(activity!!, dataset)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            newsRecycler.layoutManager = GridLayoutManager(activity, 2)
        } else {
            newsRecycler.layoutManager = LinearLayoutManager(activity)
        }

        return root


    }



}