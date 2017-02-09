package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.properties.containers.Property

/**
 * Created by adawolfs on 2/1/17.
 */
class PropertyListInteractor : MvpContract.Interactor {

    override fun getItems() : List<Property> {


        val list : MutableList<Property> = mutableListOf()
        val p1 = Property(
                title= "Opcion 1",
                description = "Loremipsum kasdjfjñlkf sdafj kjsadf lskdjf lñksfj asdlfkjfk s dskjfajhfhlajskdfhuerhkjbnvc hvjh sfasdfiu kjewn rniusdpf af",
                bedrooms = 2,
                bathrooms = 3,
                latitude = -90.4416055,
                longitude = 80.0541655,
                type = "C",
                surface = 144.22F,
                price = 8513.22,
                currency = 1,
                address = "Guatemala")
        list.add(p1)
        list.add(p1)
        list.add(p1)
        list.add(p1)
        list.add(p1)
        list.add(p1)
        list.add(p1)

        return list
    }
}