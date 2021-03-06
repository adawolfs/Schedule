package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.properties.model.Property
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by adawolfs on 2/1/17.
 */
class PropertyListInteractor : MvpContract.Interactor {

    val database = FirebaseDatabase.getInstance().reference

    override fun getItems() : Any {
        return database.child("properties")
        /*

        val list : MutableList<Property> = mutableListOf()
        val p1 = Property(
                title= "Opcion 1",
                description = "Loremipsum kasdjfjñlkf sdafj kjsadf lskdjf lñksfj asdlfkjfk s dskjfajhfhlajskdfhuerhkjbnvc hvjh sfasdfiu kjewn rniusdpf af",
                bedrooms = 2,
                bathrooms = 3,
                latitude = -90.4416055,
                longitude = 80.0541655,
                type = "Casa",
                category = "Venta",
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
        */
    }

    override fun writeNewPost(property : Property) {
        val propertiesRef = database.child("properties").push()
        propertiesRef.setValue(property)
    }
}