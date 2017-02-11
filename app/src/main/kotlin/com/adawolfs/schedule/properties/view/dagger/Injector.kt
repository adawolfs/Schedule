package com.adawolfs.schedule.properties.view.dagger

import com.adawolfs.schedule.properties.view.PropertyView

/**
 * Created by adawolfs on 9/02/17.
 */
class Injector {

    class inject(view: PropertyView) {
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