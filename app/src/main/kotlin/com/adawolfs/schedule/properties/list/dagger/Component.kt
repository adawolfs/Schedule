package com.adawolfs.schedule.properties.list.dagger

import com.adawolfs.schedule.properties.list.PropertyList
import dagger.Component
import javax.inject.Singleton

/**
 * Created by adawolfs on 2/1/17.
 */

@Singleton
@Component(modules = arrayOf(Module::class))
interface Component {
    fun inject(activity: PropertyList)
}