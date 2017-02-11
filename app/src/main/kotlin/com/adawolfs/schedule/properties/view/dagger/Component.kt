package com.adawolfs.schedule.properties.view.dagger

import com.adawolfs.schedule.properties.view.MvpContract
import dagger.Component
import javax.inject.Singleton

/**
 * Created by adawolfs on 9/02/17.
 */

@Singleton
@Component(modules = arrayOf(Module::class))
interface Component {
    fun inject(view : MvpContract.View)
}