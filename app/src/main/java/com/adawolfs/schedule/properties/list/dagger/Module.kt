package com.adawolfs.schedule.properties.list.dagger

import android.content.Context
import com.adawolfs.schedule.properties.list.PropertyList
import com.adawolfs.schedule.properties.list.PropertyListInteractor
import com.adawolfs.schedule.properties.list.PropertyListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by adawolfs on 2/1/17.
 */
@Module
class Module(view: PropertyList) {

    private val context: Context
    private val propertyList: PropertyList

    init {
        this.context = view
        this.propertyList = view
    }

    @Provides
    @Singleton
    internal fun provideInteractor(): PropertyListInteractor {
        return PropertyListInteractor()
    }

    @Provides
    @Singleton
    internal fun provideView(): PropertyList {
        return propertyList
    }

    @Provides
    @Singleton
    internal fun providePresenter(interactor: PropertyListInteractor, view: PropertyList): PropertyListPresenter {
        return PropertyListPresenter(interactor, view)
    }

}
