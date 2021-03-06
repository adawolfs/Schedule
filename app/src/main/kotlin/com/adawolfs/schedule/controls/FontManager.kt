package com.adawolfs.schedule.controls

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



/**
 * Created by adawolfs on 6/02/17.
 */
class FontManager {

    companion object{
        val ROOT = "fonts/"
        val FONTAWESOME = ROOT + "fontawesome-webfont.ttf"

        fun getTypeface(context: Context, font: String) : Typeface{
            return Typeface.createFromAsset(context.assets, font)
        }

        fun markAsIconContainer(v: View, typeface: Typeface) {
            if (v is ViewGroup) {
                for (i in 0..v.childCount - 1) {
                    val child = v.getChildAt(i)
                    markAsIconContainer(child, typeface)
                }
            } else if (v is TextView) {
                v.typeface = typeface
            }
        }
    }


}