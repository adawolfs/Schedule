package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.mvp.BaseInteractor
import com.adawolfs.schedule.mvp.BasePresenter
import com.adawolfs.schedule.mvp.BaseView
import com.adawolfs.schedule.properties.model.Property

/**
 * Created by adawolfs on 2/1/17.
 */
class MvpContract {

    interface View : BaseView {
        fun fillRecyclerView(adapter : List<Property>)
    }

    interface Presenter: BasePresenter<View> {
        fun loadItems()

        fun setItems()
    }

    interface Interactor: BaseInteractor {
        fun getItems() : List<Property>
    }
}