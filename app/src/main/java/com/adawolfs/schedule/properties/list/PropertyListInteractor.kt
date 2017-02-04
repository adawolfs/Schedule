package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.properties.containers.Property

/**
 * Created by adawolfs on 2/1/17.
 */
class PropertyListInteractor : MvpContract.Interactor {

    override fun getItems() : List<Property> {

        val list : MutableList<Property> = mutableListOf()

        list.add(Property(description = "Opcion 1", bedrooms = 2, bathrooms = 1,
                latitude = 14.581851F, longitude = -90.495427F, address = "Guatemala"))

        list.add(Property(description = "Opcion 2", bedrooms = 2, bathrooms = 1,
                latitude = 14.581851F, longitude = -90.495427F, address = "Guatemala"))

        list.add(Property(description = "Opcion 3", bedrooms = 2, bathrooms = 1,
                latitude = 14.581851F, longitude = -90.495427F, address = "Guatemala"))

        list.add(Property(description = "Opcion 4", bedrooms = 2, bathrooms = 1,
                latitude = 14.581851F, longitude = -90.495427F, address = "Guatemala"))

        return list
    }
}