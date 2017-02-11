package com.adawolfs.schedule.properties.list.dagger

import com.adawolfs.schedule.properties.list.PropertyList

/**
 * Created by adawolfs on 2/1/17.
 */
class Injector {

    class inject(view: PropertyList) {
        private var component: Component? = null
        init{
            if (component == null) {
                component = DaggerComponent
                        .builder()
                        .module(Module(view))
                        .build()
            }
            component!!.inject(view)
        }
    }

}