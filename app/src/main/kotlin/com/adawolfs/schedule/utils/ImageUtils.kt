package com.adawolfs.schedule.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Environment
import android.view.View
import android.widget.ImageView
import java.io.File
import java.io.FileOutputStream


/**
 * Created by adawolfs on 9/02/17.
 */
class ImageUtils {
    companion object{
        fun getLocalBitmapUri(imageView: ImageView): Uri? {
            // Extract Bitmap from ImageView drawable
            val drawable = imageView.drawable
            var bmp: Bitmap? = null
            if (drawable is BitmapDrawable) {
                bmp = drawable.bitmap
            } else {
                return null
            }
            // Store image to default external storage directory
            var bmpUri: Uri? = null
            try {
                val file = File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS), "share_image_" + System.currentTimeMillis() + ".png")
                file.parentFile.mkdirs()
                val out = FileOutputStream(file)
                bmp!!.compress(Bitmap.CompressFormat.PNG, 90, out)
                out.close()
                bmpUri = Uri.fromFile(file)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return bmpUri
        }

        fun getBitmapFromView(view: View): Bitmap {
            //Define a bitmap with the same size as the view
            val returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888)
            //Bind a canvas to it
            val canvas = Canvas(returnedBitmap)
            //Get the view's background
            val bgDrawable = view.getBackground()
            if (bgDrawable != null)
            //has background drawable, then draw it on the canvas
                bgDrawable!!.draw(canvas)
            else
            //does not have background drawable, then draw white background on the canvas
                canvas.drawColor(Color.WHITE)
            // draw the view on the canvas
            view.draw(canvas)
            //return the bitmap
            return returnedBitmap
        }
    }
}