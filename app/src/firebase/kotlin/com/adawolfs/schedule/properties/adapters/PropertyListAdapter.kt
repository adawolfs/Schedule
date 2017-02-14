package com.adawolfs.schedule.properties.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.adawolfs.schedule.R
import com.adawolfs.schedule.properties.list.MvpContract
import com.adawolfs.schedule.properties.model.Property
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.Query
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_item.view.*

/**
 * Created by adawolfs on 2/1/17.`
 */
class PropertyListAdapter(query : Query, var v : MvpContract.View):
        FirebaseRecyclerAdapter<Property, PropertyListAdapter.ViewHolder>(Property::class.java, R.layout.card_item, PropertyListAdapter.ViewHolder::class.java, query) {

    companion object{
        val URL = "https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg"
    }

    override fun populateViewHolder(viewHolder: ViewHolder?, model: Property?, position: Int) {
        val postRef = getRef(position)

        // Set click listener for the whole post view
        val postKey = postRef.key

        model.let {
            viewHolder?.bindProperty(it!!, v)
        }

    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        fun bindProperty(property: Property, v: MvpContract.View){
            with(property){
                itemView.property_description.text = description
                itemView.property_address.text = address
                itemView.tag = this
                itemView.setOnClickListener(v.onItemClick)
                Picasso.with(v.getContext()).load(URL).into(itemView.property_photo)
            }
        }

    }
}