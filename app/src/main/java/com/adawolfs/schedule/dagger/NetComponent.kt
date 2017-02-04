package com.adawolfs.schedule.dagger

import com.adawolfs.schedule.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by adawolfs on 2/2/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface NetComponent {
    fun inject(activity: MainActivity)
}