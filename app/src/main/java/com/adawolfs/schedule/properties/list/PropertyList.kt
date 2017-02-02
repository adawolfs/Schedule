package com.adawolfs.schedule.properties.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.adawolfs.schedule.R
import com.adawolfs.schedule.mvp.BaseActivity
import com.adawolfs.schedule.properties.list.adapters.PropertyListAdapter
import com.adawolfs.schedule.properties.list.dagger.Injector
import kotlinx.android.synthetic.main.activity_property_list.*
import javax.inject.Inject

class PropertyList : BaseActivity(), MvpContract.View {

    @Inject
    lateinit var presenter: PropertyListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_list)
        Injector.inject(this)
        presenter.setItems()
    }

    override fun fillRecyclerView(adapter : PropertyListAdapter) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        textView.text = "Alvin Estradda"
    }
}
