package com.adawolfs.schedule.properties.model

import java.io.Serializable

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

    var formattedPrice = ""
    get() : String{
        return if(currency == 1) {
            "$. $price"
        } else {
            "Q. $price"
        }
    }
}