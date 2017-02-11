package com.adawolfs.schedule.properties.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import com.adawolfs.schedule.R
import com.adawolfs.schedule.mvp.BaseActivity
import com.adawolfs.schedule.properties.list.adapters.PropertyListAdapter
import com.adawolfs.schedule.properties.list.dagger.Injector
import com.adawolfs.schedule.properties.model.Property
import com.adawolfs.schedule.properties.view.PropertyView
import kotlinx.android.synthetic.main.activity_property_list.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject


class PropertyList : BaseActivity(), MvpContract.View {

    @Inject
    lateinit var presenter: PropertyListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_list)
        Injector.inject(this)
        setSupportActionBar(toolbar)
        presenter.setItems()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val item = menu.findItem(R.id.action_search)
        search_view.setMenuItem(item)
        return true
    }


    override fun fillRecyclerView(items : List<Property>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PropertyListAdapter(items, this){
            startActivity<PropertyView>("PROPERTY" to it.tag)
        }
        //recyclerView.visibility = View.GONE
    }
}
