package com.adawolfs.schedule.properties.list.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adawolfs.schedule.R
import com.adawolfs.schedule.properties.containers.Property
import kotlinx.android.synthetic.main.card_item.view.*

/**
 * Created by adawolfs on 2/1/17.
 */
class PropertyListAdapter(val properties: List<Property>): RecyclerView.Adapter<PropertyListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProperty(properties[position])
    }

    override fun getItemCount() = properties.size


    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var view: View = v

        fun bindProperty(property: Property){
            with(property){
                itemView.property_description.text = description
            }
        }

    }
}