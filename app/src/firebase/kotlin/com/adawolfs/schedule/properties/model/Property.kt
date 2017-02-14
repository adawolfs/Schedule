package com.adawolfs.schedule.properties.model

import java.io.Serializable
import java.util.*

/**
 * Created by adawolfs on 2/1/17.
 */

data class Property(val title: String,
                    val description: String,
                    val bedrooms: Int,
                    val bathrooms: Int,
                    val latitude: Double,
                    val longitude: Double,
                    val type: String,
                    val category: String,
                    val surface: Float,
                    val price: Double,
                    val currency: Int,
                    val address: String) : Serializable {

    constructor():this("", "", 0, 0, 0.0, 0.0, "", "", 0f, 0.0, 0, "")

    var formattedPrice = ""
    get() : String{
        return if(currency == 1) {
            "$. $price"
        } else {
            "Q. $price"
        }
    }

    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("title", title)
        result.put("description", description)
        result.put("bedrooms", bedrooms)
        result.put("bathrooms", bathrooms)
        result.put("latitude", latitude)
        result.put("longitude", longitude)
        result.put("type", type)
        result.put("category", category)
        result.put("surface", surface)
        result.put("price", price)
        result.put("currency", currency)
        result.put("address", address)
        return result
    }
}