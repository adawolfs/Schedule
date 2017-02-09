package com.adawolfs.schedule.properties.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.ShareActionProvider
import android.view.Menu
import android.view.MenuItem
import com.adawolfs.schedule.R
import com.adawolfs.schedule.mvp.BaseActivity
import com.adawolfs.schedule.properties.containers.Property
import com.adawolfs.schedule.properties.list.adapters.PropertyListAdapter
import com.adawolfs.schedule.properties.view.dagger.Injector
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

        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.setType("text/plain")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "Alvin")

        setShareIntent(sharingIntent)


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
        price.text = property?.formattedPrice
        parking_number.text = 2.toString()
        Picasso.with(this).load(PropertyListAdapter.URL).into(header)
    }

}
