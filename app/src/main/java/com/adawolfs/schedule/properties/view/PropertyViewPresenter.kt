package com.adawolfs.schedule.properties.view

import com.adawolfs.schedule.mvp.BasePresenterImpl
import com.adawolfs.schedule.properties.containers.Property

/**
 * Created by adawolfs on 9/02/17.
 */
class PropertyViewPresenter(interactor : PropertyViewInteractor, view : PropertyView) :
        BasePresenterImpl<MvpContract.View>(view), MvpContract.Presenter{


    lateinit var property: Property

    init {
        loadItem()
    }

    override fun loadItem() {

    }

    override fun setItem() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}