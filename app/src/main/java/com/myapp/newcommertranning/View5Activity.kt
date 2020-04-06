package com.myapp.newcommertranning

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapp.newcommertranning.Adapter.RecyclerAdapter2
import kotlinx.android.synthetic.main.activity_view2.*
import kotlinx.android.synthetic.main.user_add.*
import kotlinx.android.synthetic.main.user_add.toolbar

class View5Activity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.moai_group_list)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val hoges = resources.getStringArray(R.array.hoges).toMutableList()

        viewAdapter = RecyclerAdapter2(this, this, hoges)
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }
}