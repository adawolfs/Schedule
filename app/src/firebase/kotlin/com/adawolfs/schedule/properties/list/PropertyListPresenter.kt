package com.adawolfs.schedule.properties.list

import com.adawolfs.schedule.mvp.BasePresenterImpl
import com.adawolfs.schedule.properties.adapters.PropertyListAdapter
import com.adawolfs.schedule.properties.model.Property
import com.google.firebase.database.Query

/**
 * Created by adawolfs on 2/1/17.
 */

class PropertyListPresenter(interactor: PropertyListInteractor, view: PropertyList):
        BasePresenterImpl<MvpContract.View>(view), MvpContract.Presenter{

    var i : PropertyListInteractor = interactor

    lateinit var items : Query

    init {
        val p1 = Property(
                title= "Opcion 1",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et arcu et metus accumsan tempor et sit amet lorem. Nullam eros mi, porttitor non hendrerit ut, varius nec justo. Pellentesque tellus tellus, hendrerit et purus vel, semper mollis nulla. Ut id porttitor lorem. Nullam aliquam ligula elit, vitae sollicitudin ligula vulputate nec. Integer porttitor porta purus, ut dignissim neque commodo eget. Aenean felis mi, tempus sed magna a, condimentum sagittis diam. Suspendisse risus tellus, dapibus sit amet tortor posuere, bibendum condimentum diam. Morbi eleifend mauris id augue fermentum, eget ornare sem molestie. Sed vitae ex ut libero fringilla scelerisque quis ut nisl. Sed rutrum nulla mi, pretium vehicula mi pulvinar et. Nam laoreet libero a odio euismod posuere. Nam tortor nisl, faucibus auctor dignissim in, feugiat id nunc. Curabitur volutpat congue ornare. Etiam consectetur fringilla enim. Donec varius ipsum sit amet nisl rutrum sollicitudin.",
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

        //i.writeNewPost(p1)
        loadItems()
    }

    override fun loadItems() {
        if(i.getItems() is Query)
            items = i.getItems() as Query
        else
            throw IllegalArgumentException("The items needs to be a: com.google.firebase.database.Query")
    }

    override fun setItems() {
        var adapter = PropertyListAdapter(items, view!!)
        view?.fillRecyclerView(adapter)
    }

}