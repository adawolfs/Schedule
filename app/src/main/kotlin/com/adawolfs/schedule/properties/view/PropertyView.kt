package com.adawolfs.schedule.properties.view

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore.Images
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.ShareActionProvider
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import com.adawolfs.schedule.R
import com.adawolfs.schedule.mvp.BaseActivity
import com.adawolfs.schedule.properties.list.adapters.PropertyListAdapter
import com.adawolfs.schedule.properties.model.Property
import com.adawolfs.schedule.properties.view.dagger.Injector
import com.adawolfs.schedule.utils.ImageUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_property.*
import kotlinx.android.synthetic.main.content_property.*
import javax.inject.Inject



class PropertyView : BaseActivity(), MvpContract.View {

    @Inject
    lateinit var presenter : MvpContract.Presenter
    companion object{
        val PROPERTY = "PROPERTY"
    }

    var mShareActionProvider: ShareActionProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        Injector.inject(this)
        val property = intent.extras?.getSerializable(PROPERTY) as Property?
        loadProperty(property)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.view_menu, menu)
        val item = menu?.findItem(R.id.menu_item_share) as MenuItem
        mShareActionProvider = ShareActionProvider(this)
        MenuItemCompat.setActionProvider(item, mShareActionProvider)

        intent = sendBitmap(ImageUtils.getBitmapFromView(coordinator_container))
        setShareIntent(intent)
        return true
    }

    fun setShareIntent(shareIntent: Intent) {
        if (mShareActionProvider != null) {
            mShareActionProvider?.setShareIntent(shareIntent);
        }
    }

    override fun loadProperty(property: Property?) {
        collapsing_toolbar.title = property?.title
        property_address.text = property?.address
        bath_number.text = property?.bathrooms.toString()
        bed_number.text = property?.bedrooms.toString()
        surface.text = property?.surface.toString()
        description.text = property?.description
        type.text = property?.type
        category.text = property?.category
        price.text = property?.formattedPrice
        parking_number.text = 2.toString()
        Picasso.with(this).load(PropertyListAdapter.URL).into(header)
    }

    fun sendBitmap(bitmap : Bitmap) : Intent {
        val emailIntent = Intent(android.content.Intent.ACTION_SEND, Uri.parse("mailto:"))
        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) {
            val pathofBmp = Images.Media.insertImage(contentResolver, bitmap, "title", null)
            val bmpUri = Uri.parse(pathofBmp)
            val emailIntent1 = Intent(android.content.Intent.ACTION_SEND)
            emailIntent1.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            emailIntent1.putExtra(Intent.EXTRA_STREAM, bmpUri)
            emailIntent1.type = "text/html"


            emailIntent.type = "text/html"
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Alvin")
            emailIntent.putExtra(android.content.Intent.EXTRA_HTML_TEXT, Html.fromHtml("<font color='#ff123456'>TEST</font>"))
        }
        return emailIntent
    }

}
