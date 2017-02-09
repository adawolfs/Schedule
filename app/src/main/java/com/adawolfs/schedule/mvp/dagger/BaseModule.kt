package com.adawolfs.schedule.mvp.dagger

import com.adawolfs.schedule.properties.list.PropertyListPresenter

/**
 * Created by adawolfs on 9/02/17.
 */
interface BaseModule<I, V> {



    fun provideInteractor(): I

    fun provideView(): V

    fun providePresenter(interactor: I, view: V): PropertyListPresenter
}