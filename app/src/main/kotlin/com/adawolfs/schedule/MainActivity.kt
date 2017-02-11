package com.adawolfs.schedule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adawolfs.schedule.properties.list.PropertyList
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(intentFor<PropertyList>())

    }
}
