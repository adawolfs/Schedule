package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.mvp.BasePresenterImpl
import com.adawolfs.schedule.properties.containers.Property
import com.adawolfs.schedule.properties.list.adapters.PropertyListAdapter

/**
 * Created by adawolfs on 2/1/17.
 */





class PropertyListPresenter(interactor: PropertyListInteractor, view: PropertyList):
        BasePresenterImpl<MvpContract.View>(view), MvpContract.Presenter{

    var i : PropertyListInteractor = interactor

    lateinit var items : List<Property>

    init {
        loadItems()
    }

    override fun loadItems() {
        items = i.getItems()
    }

    override fun setItems() {
        displayItems(items)
    }

    private fun displayItems(items: List<Property>){
        view?.fillRecyclerView(items)
    }

}