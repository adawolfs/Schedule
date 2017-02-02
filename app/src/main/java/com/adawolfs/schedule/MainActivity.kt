package com.adawolfs.schedule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.adawolfs.schedule.properties.list.PropertyList
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(intentFor<PropertyList>())

    }
}
