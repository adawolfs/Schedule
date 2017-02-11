package com.adawolfs.schedule
import android.app.Application
import com.adawolfs.schedule.controls.FontAwesomeModule
import com.adawolfs.schedule.dagger.AppModule
import com.adawolfs.schedule.dagger.DaggerNetComponent
import com.adawolfs.schedule.dagger.NetComponent
import com.adawolfs.schedule.dagger.NetModule
import com.joanzapata.iconify.Iconify

/**
 * Created by adawolfs on 2/2/17.
 */
class ScheduleApp : Application() {

    lateinit var netComponent: NetComponent

    override fun onCreate(){
        super.onCreate()
        netComponent = DaggerNetComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(""))
                .build()
        Iconify.with(FontAwesomeModule())

    }
}