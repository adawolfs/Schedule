package com.adawolfs.schedule.properties.list.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adawolfs.schedule.R
import com.adawolfs.schedule.properties.model.Property
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_item.view.*

/**
 * Created by adawolfs on 2/1/17.
 */
class PropertyListAdapter(val properties: List<Property>, val context: Context, val listener: (View) -> Unit): RecyclerView.Adapter<PropertyListAdapter.ViewHolder>() {

    companion object{
        val URL = "https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProperty(properties[position], context, listener)
    }

    override fun getItemCount() = properties.size


    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var view: View = v

        fun bindProperty(property: Property, context: Context, listener: (View) -> Unit){
            with(property){
                itemView.property_description.text = description
                itemView.property_address.text = address
                itemView.tag = this
                itemView.setOnClickListener(listener)
                Picasso.with(context).load(URL).into(itemView.property_photo)
            }
        }

    }
}