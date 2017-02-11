package com.adawolfs.schedule.properties.view.dagger

import android.content.Context
import com.adawolfs.schedule.properties.view.PropertyView
import com.adawolfs.schedule.properties.view.PropertyViewInteractor
import com.adawolfs.schedule.properties.view.PropertyViewPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by adawolfs on 9/02/17.
 */
@Module
class Module(view: PropertyView){

    private val context: Context
    private val propertyView: PropertyView

    init {
        this.context = view
        this.propertyView = view
    }

    @Provides
    @Singleton
    fun provideInteractor(): PropertyViewInteractor {
        return PropertyViewInteractor()
    }

    @Provides
    @Singleton
    fun provideView(): PropertyView {
        return propertyView
    }

    @Provides
    @Singleton
    fun providePresenter(interactor: PropertyViewInteractor, view: PropertyView): PropertyViewPresenter {
        return PropertyViewPresenter(interactor, view)
    }

}
