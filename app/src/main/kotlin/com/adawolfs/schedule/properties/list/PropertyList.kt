package com.adawolfs.schedule.properties.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import com.adawolfs.schedule.R
import com.adawolfs.schedule.mvp.BaseActivity
import com.adawolfs.schedule.properties.adapters.PropertyListAdapter
import com.adawolfs.schedule.properties.create.PropertyCreate
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
        fab_new_property.setOnClickListener {
            newProperty()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val item = menu.findItem(R.id.action_search)
        search_view.setMenuItem(item)
        return true
    }


    override fun fillRecyclerView(items : List<Property>) {

    }

    override fun fillRecyclerView(adapter: PropertyListAdapter) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun newProperty(){
        startActivity<PropertyCreate>()
    }
    override val onItemClick: View.OnClickListener
        get() {
            return View.OnClickListener{
                startActivity<PropertyView>("PROPERTY" to it.tag)
            }
        }
}
