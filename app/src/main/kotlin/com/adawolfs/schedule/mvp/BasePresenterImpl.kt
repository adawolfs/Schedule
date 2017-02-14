package com.adawolfs.schedule.mvp

/**
 * Created by adawolfs on 2/1/17.
 */

open class BasePresenterImpl<V: BaseView>(var view: V?) : BasePresenter<V> {

    override fun deatachView() {
        view = null
    }


}
