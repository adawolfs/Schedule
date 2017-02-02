package com.adawolfs.schedule.mvp

/**
 * Created by adawolfs on 1/26/17.
 */
interface BasePresenter<V: BaseView> {

    fun deatachView()

}