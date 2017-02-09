package com.adawolfs.schedule.properties.view

import com.adawolfs.schedule.mvp.BaseInteractor
import com.adawolfs.schedule.mvp.BasePresenter
import com.adawolfs.schedule.mvp.BaseView
import com.adawolfs.schedule.properties.containers.Property

/**
 * Created by adawolfs on 2/1/17.
 */
class MvpContract {

    interface View : BaseView {
        fun loadProperty(property: Property?)
    }

    interface Presenter: BasePresenter<View> {
        fun loadItem()
        fun setItem()
    }

    interface Interactor: BaseInteractor {
        fun getItems() : List<Property>
    }
}