package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.mvp.BaseInteractor
import com.adawolfs.schedule.mvp.BasePresenter
import com.adawolfs.schedule.mvp.BaseView
import com.adawolfs.schedule.properties.adapters.PropertyListAdapter
import com.adawolfs.schedule.properties.model.Property

/**
 * Created by adawolfs on 2/1/17.
 */
class MvpContract {

    interface View : BaseView {
        fun fillRecyclerView(adapter : List<Property>)
        fun fillRecyclerView(adapter: PropertyListAdapter)
        fun newProperty()
        val  onItemClick: android.view.View.OnClickListener
    }

    interface Presenter: BasePresenter<View> {
        fun loadItems()

        fun setItems()
    }

    interface Interactor: BaseInteractor {
        fun getItems() : Any
        fun writeNewPost(property: Property)
    }
}