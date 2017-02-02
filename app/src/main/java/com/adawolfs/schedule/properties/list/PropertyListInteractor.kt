package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.properties.containers.Property

/**
 * Created by adawolfs on 2/1/17.
 */
class PropertyListInteractor : MvpContract.Interactor {

    override fun getItems() : List<Property>{
        val list : MutableList<Property> = mutableListOf()
        list.add(Property("Opcion 1"))
        list.add(Property("Opcion 2"))
        list.add(Property("Opcion 3"))
        list.add(Property("Opcion 4"))
        return list
    }
}